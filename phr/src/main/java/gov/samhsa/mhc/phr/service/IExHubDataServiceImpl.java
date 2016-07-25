package gov.samhsa.mhc.phr.service;


import gov.samhsa.mhc.phr.service.dto.PatientDataResponse;
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

    @Value("${phr.iexhub.url}")
    private String iexHubUrl;

    @Value("${phr.iexhub.ssoauth}")
    private String ssOauth;

    @Autowired
    private AccountService accountService;

    @Override
    public PatientDataResponse getPatientData(String email) {

        PatientDataResponse patientDataResponse = null;
        // REST api call
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        HttpHeaders reqHeader = new HttpHeaders();
        Long patientId = accountService.findPatientByEmail(email).getId();
        String iexHubSSOauth = buildIExHubSSOauth(patientId, ssOauth);
        reqHeader.add("ssoauth", iexHubSSOauth);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        List<MediaType> accepts = new ArrayList<MediaType>();
        accepts.add(MediaType.APPLICATION_JSON);
        reqHeader.setAccept(accepts);

        HttpEntity<PatientDataResponse> reqEntity = new HttpEntity<PatientDataResponse>(reqHeader);

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

    private String buildIExHubSSOauth(Long patientId, String ssOauth) {
        String patientIdentifier = accountService.buildPatientIdentifier(patientId).getPatientIdentifier();
        Assert.notNull(patientIdentifier, "patientIdentifier cannot be null.");
        return ssOauth.replace("PATIENT_IDENTIFIER", patientIdentifier);
    }
}
