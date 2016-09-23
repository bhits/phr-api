package gov.samhsa.c2s.phr.service.reference;


import gov.samhsa.c2s.phr.service.dto.LookupDto;

import java.util.List;

public interface StateCodeService {
    List<LookupDto> findAllStateCodes();
}
