package gov.samhsa.mhc.phr.web;


import gov.samhsa.mhc.phr.service.AccountService;
import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @PreAuthorize("#oauth2.hasScope('phr.hie_write')")
    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    void signupPatient(@RequestBody SignupDto signupDto) {
        accountService.createPatient(signupDto);
    }

    @RequestMapping(value = "/patients/{patientId}/profile")
    public PatientDto getPatient(@PathVariable long patientId) {
        return accountService.findPatientById(patientId);
    }

}
