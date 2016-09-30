package gov.samhsa.c2s.phr.service;


import gov.samhsa.c2s.phr.service.dto.*;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

public interface AccountService {

    boolean checkDuplicatePatient(SignupDto signupDto);

    SignupDto createPatient(SignupDto signupDto);

    PatientDto findPatientById(long id);

    SignupDto updatePatient(SignupDto signupDto, long id);

    PatientListDto findAllPatientsInPage(String pageNumber);

    List<PatientDto> findAllPatientByFirstNameAndLastName(StringTokenizer tokenizer);

    PatientDto findPatientByEmail(String email);

    PatientDemographicResponse findPatientByDemographic(String firstName, String lastName, Date birthDate, String genderCode);

    PatientIdentifierDto buildPatientIdentifier(long patientId);
}
