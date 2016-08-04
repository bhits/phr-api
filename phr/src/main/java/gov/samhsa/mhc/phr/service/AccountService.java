package gov.samhsa.mhc.phr.service;


import gov.samhsa.mhc.phr.service.dto.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

@Service
public interface AccountService {
    boolean checkduplicatePatient(SignupDto signupDto);

    SignupDto createPatient(SignupDto signupDto);

    PatientDto findPatientById(long id);

    SignupDto updatePatient(SignupDto signupDto, long id);

    PatientListDto findAllPatientsInPage(String pageNumber);

    List<PatientDto> findAllPatientByFirstNameAndLastName(StringTokenizer tokenizer);

    PatientDto findPatientByEmail(String email);

    PatientDemographicResponse findPatientByDemographic(String firstName, String lastName, Date birthDate, String genderCode);

    PatientIdentifierDto buildPatientIdentifier(long patientId);
}
