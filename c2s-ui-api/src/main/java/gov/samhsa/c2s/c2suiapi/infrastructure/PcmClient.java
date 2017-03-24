package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentAttestationDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentRevocationDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.DetailedConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PageableDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PurposeDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;

@FeignClient("pcm")
public interface PcmClient {

    @RequestMapping(value = "/patients/{patientId}/providers", method = RequestMethod.GET)
    List<ConsentProviderDto> getProviders(@PathVariable("patientId") Long patientId);

    @RequestMapping(value = "/patients/{patientId}/providers", method = RequestMethod.POST)
    void saveProviders(@PathVariable("patientId") Long patientId,
                       @Valid @RequestBody IdentifiersDto providerIdentifiersDto);

    @RequestMapping(value = "/patients/{patientId}/providers/{providerId}", method = RequestMethod.DELETE)
    void deleteProvider(@PathVariable("patientId") Long patientId,
                        @PathVariable("providerId") Long providerId);

    @RequestMapping(value = "/patients/{patientId}/consents", method = RequestMethod.GET)
    PageableDto<DetailedConsentDto> getConsents(@PathVariable("patientId") Long patientId,
                                                @RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "size", required = false) Integer size);

    @RequestMapping(value = "/patients/{patientId}/consents/{consentId}", method = RequestMethod.GET)
    Object getConsent(@PathVariable("patientId") Long patientId,
                      @PathVariable("consentId") Long consentId,
                      @RequestParam(value = "format", required = false) String format);

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