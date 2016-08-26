package gov.samhsa.c2s.phr.web;


import gov.samhsa.c2s.phr.service.dto.LookupDto;
import gov.samhsa.c2s.phr.service.reference.StateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/statecodes")
public class StateCodeController {

    @Autowired
    private StateCodeService stateCodeService;

    @RequestMapping(method = RequestMethod.GET)
    public List<LookupDto> listState() {
        return stateCodeService.findAllStateCodes();
    }
}
