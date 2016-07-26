package gov.samhsa.mhc.phr.service.dto;

import lombok.Value;

@Value
public class PatientIdentifier {
    private String medicalRecordNumber;
    private String domainId;
    private String assigningAuthority;
    private String patientIdentifier;
}