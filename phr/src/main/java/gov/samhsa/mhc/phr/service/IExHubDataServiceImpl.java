package gov.samhsa.mhc.phr.service;


import gov.samhsa.mhc.phr.jsondomain.PatientDataResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sadhana.chandra on 10/14/2015.
 */
@Component
public class IExHubDataServiceImpl implements IExHubDataService {

    @Value("${phr.iexhub.url}")
    private String iexHubUrl;

    @Value("${phr.iexhub.ssoauth}")
    private String ssOauth;



    public PatientDataResponse getPatientData() {

        PatientDataResponse patientDataResponse = null;
        // REST api call
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        HttpHeaders reqHeader = new HttpHeaders();
        reqHeader.add("ssoauth", ssOauth);

        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        List<MediaType> accepts = new ArrayList<MediaType>();
        accepts.add(MediaType.APPLICATION_JSON);
        reqHeader.setAccept(accepts);

        HttpEntity<PatientDataResponse> reqEntity = new HttpEntity<PatientDataResponse>(reqHeader);

      ResponseEntity<PatientDataResponse> pdrEntitiy = restTemplate.exchange(iexHubUrl, HttpMethod.GET, reqEntity, PatientDataResponse.class);
        if(pdrEntitiy.getStatusCode().equals(HttpStatus.OK))
            patientDataResponse = pdrEntitiy.getBody();
       // else
            //TODO:: need to implement error handling
        System.out.println("Response Status : " + pdrEntitiy.getStatusCode());

        final HttpHeaders headers = pdrEntitiy.getHeaders();
        System.out.println("headers in response are : " + headers);
        return patientDataResponse;
    }

}
