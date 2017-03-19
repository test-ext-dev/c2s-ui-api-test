package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import gov.samhsa.c2s.c2suiapi.service.PcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pcm")
public class PcmRestController {

    @Autowired
    private PcmService pcmService;

    @GetMapping("/providers")
    List<FlattenedSmallProviderDto> getProviders() {
        List<FlattenedSmallProviderDto> flattenedSmallProviderDtos = pcmService.getProviders();
        return flattenedSmallProviderDtos;
    }

    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProviders(@Valid @RequestBody IdentifiersDto providerIdentifiersDto) {
        pcmService.saveProviders(providerIdentifiersDto);
    }
}