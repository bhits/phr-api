package gov.samhsa.c2s.phr.service.reference;


import gov.samhsa.c2s.phr.service.dto.LookupDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by cindy.li on 12/16/2015.
 */
@Service
public interface StateCodeService {
    List<LookupDto> findAllStateCodes();

}
