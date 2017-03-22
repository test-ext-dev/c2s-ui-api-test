package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("pcm")
public interface PcmClient {

    @RequestMapping(value = "/patients/{patientId}/providers", method = RequestMethod.GET)
    List<FlattenedSmallProviderDto> getProviders(@PathVariable("patientId") Long patientId);

    @RequestMapping(value = "/patients/{patientId}/providers", method = RequestMethod.POST)
    void saveProviders(@PathVariable("patientId") Long patientId,
                       @Valid @RequestBody IdentifiersDto providerIdentifiersDto);

    @RequestMapping(value = "/patients/{patientId}/providers/{providerId}", method = RequestMethod.DELETE)
    void deleteProvider(@PathVariable("patientId") Long patientId,
                        @PathVariable("providerId") Long providerId);

    @RequestMapping(value = "/patients/{patientId}/consents", method = RequestMethod.POST)
    void saveConsent(@PathVariable("patientId") Long patientId,
                     @Valid @RequestBody ConsentDto consentDto);

    @RequestMapping(value = "/patients/{patientId}/consents/{consentId}", method = RequestMethod.DELETE)
    void deleteConsent(@PathVariable("patientId") Long patientId,
                       @PathVariable("consentId") Long consentId);

    @RequestMapping(value = "/patients/{patientId}/consents/{consentId}", method = RequestMethod.PUT)
    void updateConsent(@PathVariable("patientId") Long patientId,
                       @PathVariable("consentId") Long consentId,
                       @Valid @RequestBody ConsentDto consentDto);

    @RequestMapping(value = "/patients/{patientId}/consents/{consentId}/attestation", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    void attestConsent(@PathVariable("patientId") Long patientId,
                       @PathVariable("consentId") Long consentId,
                       @Valid @RequestBody ConsentAttestationDto consentAttestationDto);

    @RequestMapping(value = "/patients/{patientId}/consents/{consentId}/revocation", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    void revokeConsent(@PathVariable("patientId") Long patientId,
                       @PathVariable("consentId") Long consentId,
                       @Valid @RequestBody ConsentRevocationDto consentRevocationDto);

    @RequestMapping(value = "/purposes", method = RequestMethod.GET)
    List<PurposeDto> getPurposes();
}