package gov.samhsa.c2s.phr.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class PatientDemographicResponse {
    private List<PatientDto> patientDtos;
    private String domainId;
}
