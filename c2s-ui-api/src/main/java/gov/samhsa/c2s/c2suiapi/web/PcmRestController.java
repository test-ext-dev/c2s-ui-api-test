package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.service.PcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pcm")
public class PcmRestController {

    @Autowired
    private PcmService pcmService;

    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    List<FlattenedSmallProviderDto> getProviders() {
        List<FlattenedSmallProviderDto> flattenedSmallProviderDtos = pcmService.getProviders();
        return flattenedSmallProviderDtos;
    }
}