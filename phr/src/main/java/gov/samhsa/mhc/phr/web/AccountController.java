package gov.samhsa.mhc.phr.web;


import gov.samhsa.mhc.phr.service.AccountService;
import gov.samhsa.mhc.phr.service.dto.PatientDemographicResponse;
import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.PatientListDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import gov.samhsa.mhc.phr.service.exception.PatientNotFoundException;
import lombok.val;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

@RestController
@RequestMapping("/patients")
public class AccountController {
    /**
     * The logger.
     */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${phr.domainId}")
    private String domainId;

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
        StringTokenizer tokenizer = new StringTokenizer(token, " ");
        return accountService.findAllPatientByFirstNameAndLastName(tokenizer);
    }

    @RequestMapping(value = "/patientDemographic", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public PatientDemographicResponse getPatientFullDemographic(@RequestParam("firstName") String firstName,
                                                                @RequestParam("lastName") String lastName,
                                                                @RequestParam("birthDate") @DateTimeFormat(pattern = "MM/dd/yyyy") Date birthDate,
                                                                @RequestParam("genderCode") String genderCode) {
        val response = new PatientDemographicResponse();
        val patientDtos = accountService.findPatientByDemographic(firstName, lastName, birthDate, genderCode);
        response.setPatientDtos(patientDtos);
        response.setDomainId(domainId);
        response.setPatientExist(!patientDtos.isEmpty());
        return response;
    }
}
