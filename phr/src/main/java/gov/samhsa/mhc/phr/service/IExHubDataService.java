package gov.samhsa.mhc.phr.service;

import gov.samhsa.mhc.phr.service.dto.PatientDataResponse;


/**
 * Created by sadhana.chandra on 10/14/2015.
 */
public interface IExHubDataService {
    PatientDataResponse getPatientData(Long patientId);
}

