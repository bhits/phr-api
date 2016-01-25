package gov.samhsa.mhc.phr.web;


import gov.samhsa.mhc.phr.dto.SignupDto;
import gov.samhsa.mhc.phr.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@RestController
public class AccountController
{
    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AccountService accountService;

    @PreAuthorize("#oauth2.hasScope('phr.hie.writeDocument')")
    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    void signupPatient(@RequestBody SignupDto signupDto){
            accountService.createPatient(signupDto);
    }

}
