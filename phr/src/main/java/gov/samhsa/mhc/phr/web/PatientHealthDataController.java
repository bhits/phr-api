package gov.samhsa.mhc.phr.web;

import gov.samhsa.mhc.phr.service.IExHubDataService;
import gov.samhsa.mhc.phr.service.dto.ClinicalDocumentRequest;
import gov.samhsa.mhc.phr.service.dto.PatientDataResponse;
import gov.samhsa.mhc.phr.service.exception.PatientNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

/**
 * Created by sadhana.chandra on 10/14/2015.
 */

@RestController
@RequestMapping("/patients")
public class PatientHealthDataController {
    private final String PATIENT_DATA_CACHE_NAME = "PatientData";

    @Autowired
    IExHubDataService iExHubDataService;

    @RequestMapping(value = "/healthInformation", method = RequestMethod.GET)
    @Cacheable(value = PATIENT_DATA_CACHE_NAME)
    public PatientDataResponse getPatientData(OAuth2Authentication oAuth2Authentication) {
        //TODO: if the email is not used as username
        String email = Optional.ofNullable(oAuth2Authentication)
                .map(OAuth2Authentication::getName)
                .filter(StringUtils::hasText)
                .orElseThrow(PatientNotFoundException::new);
        return iExHubDataService.getPatientData(email);
    }

    @CacheEvict(value = PATIENT_DATA_CACHE_NAME, allEntries = true)
    @RequestMapping(value = "/clearCache", method = RequestMethod.GET)
    public String clearCache() {
        return "Cache Cleared";
    }

    @RequestMapping(value = "/healthInformation/publish", method = RequestMethod.POST)
    public boolean publishDocument(@Valid @RequestBody ClinicalDocumentRequest patientDocumentDto) {
        return iExHubDataService.publishDocumentToHIE(patientDocumentDto);
    }
}
