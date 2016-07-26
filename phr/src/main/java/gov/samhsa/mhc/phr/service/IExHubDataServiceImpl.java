package gov.samhsa.mhc.phr.service;


import gov.samhsa.mhc.phr.service.dto.ClinicalDocumentRequest;
import gov.samhsa.mhc.phr.service.dto.ClinicalDocumentResponse;
import gov.samhsa.mhc.phr.service.dto.PatientDataResponse;
import gov.samhsa.mhc.phr.service.exception.DocumentNotPublishedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sadhana.chandra on 10/14/2015.
 */
@Service
public class IExHubDataServiceImpl implements IExHubDataService {

    @Autowired
    private AccountService accountService;

    @Value("${phr.iexhub.url}")
    private String iexHubUrl;

    @Value("${phr.iexhub.publish.url}")
    private String iexhubPulishUrl;

    @Value("${phr.iexhub.ssoauth}")
    private String ssOauth;

    @Override
    public PatientDataResponse getPatientData(String email) {
        RestTemplate restTemplate = new RestTemplate();

        PatientDataResponse patientDataResponse = null;
        // REST api call
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        String iexHubSSOauth = buildIExHubSSOauth(email, ssOauth);
        httpHeaders.add("ssoauth", iexHubSSOauth);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        List<MediaType> accepts = new ArrayList<MediaType>();
        accepts.add(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(accepts);

        HttpEntity<PatientDataResponse> reqEntity = new HttpEntity<PatientDataResponse>(httpHeaders);

        ResponseEntity<PatientDataResponse> pdrEntitiy = restTemplate.exchange(iexHubUrl, HttpMethod.GET, reqEntity, PatientDataResponse.class);
        if (pdrEntitiy.getStatusCode().equals(HttpStatus.OK))
            patientDataResponse = pdrEntitiy.getBody();
        // else
        //TODO:: need to implement error handling
        System.out.println("Response Status : " + pdrEntitiy.getStatusCode());

        final HttpHeaders headers = pdrEntitiy.getHeaders();
        System.out.println("headers in response are : " + headers);
        return patientDataResponse;
    }

    @Override
    public boolean publishDocumentToHIE(ClinicalDocumentRequest document) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity = new HttpEntity(document, headers);
        ResponseEntity<ClinicalDocumentResponse> response = restTemplate.exchange(iexhubPulishUrl, HttpMethod.POST, entity, ClinicalDocumentResponse.class);

        if (!response.getStatusCode().equals(HttpStatus.OK)) {
            throw new DocumentNotPublishedException("Cannot publish document in HIE.");
        }

        ClinicalDocumentResponse clinicalDocumentResponse = response.getBody();
        return clinicalDocumentResponse.isPublished();
    }

    private String buildIExHubSSOauth(String email, String ssOauth) {
        Long patientId = accountService.findPatientByEmail(email).getId();
        String patientIdentifier = accountService.buildPatientIdentifier(patientId).getPatientIdentifier();
        Assert.notNull(patientIdentifier, "patientIdentifier cannot be null.");
        return ssOauth.replace("PATIENT_IDENTIFIER", patientIdentifier);
    }
}
