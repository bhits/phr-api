package gov.samhsa.mhc.phr.web;


import gov.samhsa.mhc.phr.service.AccountService;
import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.PatientListDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import gov.samhsa.mhc.phr.service.exception.PatientNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
public class AccountController {
    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/pageNumber")
    public PatientListDto listPatients(@RequestParam("pageNumber") String pageNumber) {
        return accountService.findAllPatientsInPage(pageNumber);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    SignupDto signupPatient(@RequestBody SignupDto signupDto) {
        return accountService.createPatient(signupDto);
    }

    @RequestMapping(value = "/{patientId}/profile", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PatientDto getPatient(@PathVariable long patientId) {
        return accountService.findPatientById(patientId);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PatientDto getPatientByEmail(OAuth2Authentication oAuth2Authentication) {
        String email = Optional.ofNullable(oAuth2Authentication)
                .map(OAuth2Authentication::getName)
                .filter(StringUtils::hasText)
                .orElseThrow(PatientNotFoundException::new);
        return accountService.findPatientByEmail(email);
    }

    @RequestMapping(value = "/{patientId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    SignupDto updatePatient(@RequestBody SignupDto signupDto, @PathVariable long patientId) {
        return accountService.updatePatient(signupDto, patientId);
    }

    @RequestMapping(value = "/search/{token}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<PatientDto> searchPatients(@PathVariable String token) {
        String[] tokens = token.split("\\s*(=>|,|\\s)\\s*");
        return accountService.findAllPatientByFirstNameAndLastName(tokens);
    }
}
