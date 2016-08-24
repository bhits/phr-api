package gov.samhsa.c2s.phr.service.dto;

import lombok.Value;

@Value
public class PatientIdentifierDto {
    private String medicalRecordNumber;
    private String domainId;
    private String assigningAuthority;
    private String patientIdentifier;
}