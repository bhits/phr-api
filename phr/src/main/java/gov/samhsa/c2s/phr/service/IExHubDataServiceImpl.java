package gov.samhsa.c2s.phr.service;


import gov.samhsa.c2s.phr.service.dto.*;
import gov.samhsa.c2s.phr.service.exception.DocumentNotPublishedException;
import gov.samhsa.c2s.phr.service.exception.PatientDataCannotBeRetrievedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class IExHubDataServiceImpl implements IExHubDataService {
    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @Autowired
    private RestOperations restTemplate;

    @Value("${phr.iexhub.url}")
    private String iexHubUrl;

    @Value("${phr.iexhub.publish.url}")
    private String hiePublishURL;

    @Value("${phr.iexhub.ssoauth}")
    private String ssOauthTemplate;

    @Autowired
    private MessageSource messageSource;

    @Override
    public PatientDataResponse getPatientData(String email) {
        // REST api call
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String ssOauth = buildIExHubSSOauth(email, ssOauthTemplate);
        httpHeaders.add("ssoauth", ssOauth);

        List<MediaType> accepts = new ArrayList<>();
        accepts.add(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(accepts);

        final HttpEntity<PatientDataResponse> reqEntity = new HttpEntity<>(httpHeaders);

        final ResponseEntity<PatientDataResponse> pdrEntitiy = restTemplate.exchange(iexHubUrl, HttpMethod.GET, reqEntity, PatientDataResponse.class);
        final HttpStatus statusCode = pdrEntitiy.getStatusCode();
        logger.info("Response Status : " + statusCode);
        final HttpHeaders headers = pdrEntitiy.getHeaders();
        logger.info("headers in response are : " + headers);

        final PatientDataResponse patientDataResponse = pdrEntitiy.getBody();

        if (statusCode.is4xxClientError() || statusCode.is5xxServerError()) {
            throw new PatientDataCannotBeRetrievedException();
        }
        Locale locale  = LocaleContextHolder.getLocale();
        if (locale == null || locale.getLanguage().equalsIgnoreCase("en")) {
            return patientDataResponse;
        } else if (locale.getLanguage().equalsIgnoreCase("es")) {
            translateLablesOfMedDoc (patientDataResponse, locale);
        }
        return patientDataResponse;
    }

    @Override
    public boolean publishDocumentToHIE(ClinicalDocumentRequest document) {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(document, headers);

        try {
            ResponseEntity<ClinicalDocumentResponse> response = restTemplate.exchange(hiePublishURL, HttpMethod.POST, entity, ClinicalDocumentResponse.class);

            if (!response.getStatusCode().equals(HttpStatus.OK)) {
                logger.error("Cannot publish document in HIE.");
                throw new DocumentNotPublishedException("Cannot publish document in HIE.");
            }

            ClinicalDocumentResponse clinicalDocumentResponse = response.getBody();
            return clinicalDocumentResponse.isPublished();
        } catch (Exception e) {
            logger.error("Error in publishing document in HIE." + e.getMessage());
        }

        return false;
    }

    private String buildIExHubSSOauth(String email, String ssOauthTemplate) {
        Long patientId = accountService.findPatientByEmail(email).getId();
        String patientIdentifier = accountService.buildPatientIdentifier(patientId).getPatientIdentifier();
        Assert.notNull(patientIdentifier, "patientIdentifier cannot be null.");
        return ssOauthTemplate.replace("PATIENT_IDENTIFIER", patientIdentifier);
    }

    /**
     * Translate CDA document
     * author: Wentao Zhou
     * */
    private void translateLablesOfMedDoc (PatientDataResponse patientDataResponse, Locale locale) {
        for (Document document : patientDataResponse.getDocuments()) {
            for (CDADocument cdaDocument : document.getCdaDocuments()) {
                cdaDocument.setType(messageSource.getMessage("CDA.DOCUMENT.TYPE", null, locale));
                for (Section section : cdaDocument.getSections()) {
                    String sectionTitle = "";
                    if (section.getTitle() == null || section.getTitle() == "") {
                        continue;
                    } else {
                        sectionTitle = section.getTitle().replaceAll("[^a-zA-Z0-9]+", ".");
                    }
                    section.setTitle(messageSource.getMessage("CDA.TITLE." + sectionTitle, null, locale));
                }
            }
        }
    }
}
