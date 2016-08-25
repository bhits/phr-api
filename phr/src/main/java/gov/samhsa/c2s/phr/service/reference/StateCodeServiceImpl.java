package gov.samhsa.c2s.phr.service.reference;

import gov.samhsa.c2s.phr.domain.reference.StateCodeRepository;
import gov.samhsa.c2s.phr.domain.reference.StateCode;
import gov.samhsa.c2s.phr.service.dto.LookupDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StateCodeServiceImpl implements StateCodeService {

    /** The state code repository. */
    @Autowired
    StateCodeRepository stateCodeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LookupDto> findAllStateCodes() {

        List<LookupDto> lookups = new ArrayList<LookupDto>();

        List<StateCode> stateCodeList = stateCodeRepository.findAll();

        for (StateCode entity : stateCodeList) {
            lookups.add(modelMapper.map(entity, LookupDto.class));
        }
        return lookups;

    }
}
