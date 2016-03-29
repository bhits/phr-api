package gov.samhsa.mhc.phr.service.reference;


import gov.samhsa.mhc.phr.domain.reference.AbstractLocalDBLookupCodedConcept;
import gov.samhsa.mhc.phr.service.dto.LookupDto;
import gov.samhsa.mhc.phr.service.dto.PatientDto;
import gov.samhsa.mhc.phr.service.dto.SignupDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by cindy.li on 12/16/2015.
 */
@Service
public interface StateCodeService {
    List<LookupDto> findAllStateCodes();

}
