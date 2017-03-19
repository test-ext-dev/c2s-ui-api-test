package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("pcm")
@RequestMapping("/patients/{patientId}")
public interface PcmClient {

    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    List<FlattenedSmallProviderDto> getProviders(@PathVariable("patientId") Long patientId);
}