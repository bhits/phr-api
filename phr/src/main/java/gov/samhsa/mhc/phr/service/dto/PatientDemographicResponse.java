package gov.samhsa.mhc.phr.service.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by jiahao.li on 7/1/2016.
 */
@Data
public class PatientDemographicResponse {
    private List<PatientDto> patientDtos;
    private boolean isPatientExist;
}
