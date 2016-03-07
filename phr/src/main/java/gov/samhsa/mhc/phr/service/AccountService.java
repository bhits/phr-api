package gov.samhsa.mhc.phr.service;


import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import org.springframework.stereotype.Service;

/**
 * Created by cindy.li on 12/16/2015.
 */
@Service
public interface AccountService {
    public boolean checkduplicatePatient(SignupDto signupDto);

    public void createPatient(SignupDto signupDto);

    public PatientDto findPatientById(long id);


}
