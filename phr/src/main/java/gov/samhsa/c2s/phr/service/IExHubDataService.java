package gov.samhsa.c2s.phr.service;

import gov.samhsa.c2s.phr.service.dto.ClinicalDocumentRequest;
import gov.samhsa.c2s.phr.service.dto.PatientDataResponse;


/**
 * Created by sadhana.chandra on 10/14/2015.
 */
public interface IExHubDataService {
    PatientDataResponse getPatientData(String email);

    boolean publishDocumentToHIE(ClinicalDocumentRequest document);
}

