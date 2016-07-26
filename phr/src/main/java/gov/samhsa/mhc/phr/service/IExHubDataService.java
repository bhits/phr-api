package gov.samhsa.mhc.phr.service;

import gov.samhsa.mhc.phr.service.dto.PatientDataResponse;
import gov.samhsa.mhc.phr.service.dto.ClinicalDocumentRequest;


/**
 * Created by sadhana.chandra on 10/14/2015.
 */
public interface IExHubDataService {
    PatientDataResponse getPatientData(String email);

    boolean publishDocumentToHIE(ClinicalDocumentRequest document);
}

