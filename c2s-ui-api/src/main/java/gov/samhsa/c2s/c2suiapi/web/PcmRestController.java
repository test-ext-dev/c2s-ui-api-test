package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentAttestationDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentRevocationDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.DetailedConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PageableDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PurposeDto;
import gov.samhsa.c2s.c2suiapi.service.PcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pcm")
public class PcmRestController {

    @Autowired
    private PcmService pcmService;

    @GetMapping("/patients/providers")
    public List<ConsentProviderDto> getProviders() {
        return pcmService.getProviders();
    }

    @PostMapping("/patients/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProviders(@Valid @RequestBody IdentifiersDto providerIdentifiersDto) {
        pcmService.saveProviders(providerIdentifiersDto);
    }

    @DeleteMapping("/patients/providers/{providerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProvider(@PathVariable Long providerId) {
        pcmService.deleteProvider(providerId);
    }

    @GetMapping("/patients/consents")
    public PageableDto<DetailedConsentDto> getConsents(@RequestParam(value = "page", required = false) Integer page,
                                                       @RequestParam(value = "size", required = false) Integer size) {
        return pcmService.getConsents(page, size);
    }

    @GetMapping("/patients/consents/{consentId}")
    public Object getConsent(@PathVariable Long consentId,
                             @RequestParam(value = "format", required = false) String format) {
        return pcmService.getConsent(consentId, format);
    }

    @PostMapping("/patients/consents")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveConsent(@Valid @RequestBody ConsentDto consentDto) {
        pcmService.saveConsent(consentDto);
    }

    @DeleteMapping("/patients/consents/{consentId}")
    public void deleteConsent(@PathVariable Long consentId) {
        pcmService.deleteConsent(consentId);
    }

    @PutMapping("/patients/consents/{consentId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateConsent(@PathVariable Long consentId,
                              @Valid @RequestBody ConsentDto consentDto) {
        pcmService.updateConsent(consentId, consentDto);
    }

    @PutMapping("/patients/consents/{consentId}/attestation")
    @ResponseStatus(HttpStatus.OK)
    public void attestConsent(@PathVariable Long consentId,
                              @Valid @RequestBody ConsentAttestationDto consentAttestationDto) {
        pcmService.attestConsent(consentId, consentAttestationDto);
    }

    @PutMapping("/patients/consents/{consentId}/revocation")
    @ResponseStatus(HttpStatus.OK)
    public void revokeConsent(@PathVariable Long consentId,
                              @Valid @RequestBody ConsentRevocationDto consentRevocationDto) {
        pcmService.revokeConsent(consentId, consentRevocationDto);
    }

    @GetMapping("/purposes")
    public List<PurposeDto> getPurposes() {
        return pcmService.getPurposes();
    }
}