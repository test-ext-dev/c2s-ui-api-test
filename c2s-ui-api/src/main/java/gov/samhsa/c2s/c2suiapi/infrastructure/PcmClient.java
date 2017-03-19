package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PcmFlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("pcm")
@RequestMapping("/patients/{patientId}")
public interface PcmClient {

    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    List<PcmFlattenedSmallProviderDto> getProviders(@PathVariable("patientId") Long patientId);

    @RequestMapping(value = "/providers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    void saveProviders(@PathVariable("patientId") Long patientId,
                       @Valid @RequestBody IdentifiersDto providerIdentifiersDto);

    @RequestMapping(value = "/providers/{providerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProvider(@PathVariable("patientId") Long patientId, @PathVariable("providerId") Long providerId);
}