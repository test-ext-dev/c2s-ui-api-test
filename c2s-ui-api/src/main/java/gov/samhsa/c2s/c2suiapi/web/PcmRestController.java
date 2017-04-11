package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.*;
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

    @GetMapping("/patients/consents/{consentId}/attestation")
    public Object getAttestedConsent(@PathVariable Long consentId,
                                     @RequestParam(required = false)  String format) {
        return pcmService.getAttestedConsent(consentId, format);
    }

    @GetMapping("/patients/consents/{consentId}/revocation")
    public Object getRevokedConsent(@PathVariable Long consentId,
                                    @RequestParam(required = false)  String format) {
        return pcmService.getRevokedConsent(consentId, format);
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

    @GetMapping("/consentAttestationTerm")
    public ConsentTermDto getConsentAttestationTerm(@RequestParam(value = "id", required = false) Long id) {
        return pcmService.getConsentAttestationTerm(id);
    }

    @GetMapping("/consentRevocationTerm")
    public ConsentTermDto getConsentRevocationTerm(@RequestParam(value = "id", required = false) Long id) {
        return pcmService.getConsentRevocationTerm(id);
    }
}