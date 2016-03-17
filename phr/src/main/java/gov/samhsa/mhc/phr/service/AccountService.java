package gov.samhsa.mhc.phr.service;


import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cindy.li on 12/16/2015.
 */
@Service
public interface AccountService {
    public boolean checkduplicatePatient(SignupDto signupDto);

    public SignupDto createPatient(SignupDto signupDto);

    public PatientDto findPatientById(long id);

    public SignupDto updatePatient(SignupDto signupDto, long id);

    public Map<String, Object> findAllPatientsInPage(String pageNumber);

}
