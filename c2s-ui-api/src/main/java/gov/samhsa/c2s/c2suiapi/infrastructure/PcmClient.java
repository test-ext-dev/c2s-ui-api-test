package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@FeignClient("pcm")
@RequestMapping("/patients/{patientId}")
public interface PcmClient {

    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    List<FlattenedSmallProviderDto> getProviders(@PathVariable("patientId") Long patientId);

    @RequestMapping(value = "/providers", method = RequestMethod.POST)
    void saveProviders(@PathVariable("patientId") Long patientId,
                       @Valid @RequestBody IdentifiersDto providerIdentifiersDto);

    @RequestMapping(value = "/providers/{providerId}", method = RequestMethod.DELETE)
    void deleteProvider(@PathVariable("patientId") Long patientId,
                        @PathVariable("providerId") Long providerId);

    @RequestMapping(value = "/consents", method = RequestMethod.POST)
    void saveConsent(@PathVariable("patientId") Long patientId,
                     @Valid @RequestBody ConsentDto consentDto);

    @RequestMapping(value = "/consents/{consentId}", method = RequestMethod.DELETE)
    void deleteConsent(@PathVariable("patientId") Long patientId,
                       @PathVariable("consentId") Long consentId);

    @RequestMapping(value = "/consents/{consentId}", method = RequestMethod.PUT)
    void updateConsent(@PathVariable("patientId") Long patientId,
                       @PathVariable("consentId") Long consentId,
                       @Valid @RequestBody ConsentDto consentDto);
}