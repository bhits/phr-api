package gov.samhsa.mhc.phr.web;

import gov.samhsa.mhc.phr.service.IExHubDataService;
import gov.samhsa.mhc.phr.service.dto.PatientDataResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sadhana.chandra on 10/14/2015.
 */

@RestController
@RequestMapping("/patients")
public class PatientHealthDataController {
    /** The logger. */
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String PATIENT_DATA_CACHE_NAME="PatientData";

    @Autowired
    IExHubDataService iExHubDataService;

    @RequestMapping(value = "/healthInformation/{mrn}", method = RequestMethod.GET)
    @Cacheable(value =PATIENT_DATA_CACHE_NAME)
    public PatientDataResponse getPatientData(@PathVariable Integer mrn) {
        return iExHubDataService.getPatientData();
    }

    @CacheEvict(value = PATIENT_DATA_CACHE_NAME, allEntries = true)
    @RequestMapping(value = "/clearCache", method = RequestMethod.GET)
    public String clearCache() {
        return "Cache Cleared";
    }
}
