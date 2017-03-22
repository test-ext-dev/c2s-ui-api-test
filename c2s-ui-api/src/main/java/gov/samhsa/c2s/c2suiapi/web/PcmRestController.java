package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentAttestationDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ConsentDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import gov.samhsa.c2s.c2suiapi.service.PcmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pcm/patients")
public class PcmRestController {

    @Autowired
    private PcmService pcmService;

    @GetMapping("/providers")
    public List<FlattenedSmallProviderDto> getProviders() {
        return pcmService.getProviders();
    }

    @PostMapping("/providers")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProviders(@Valid @RequestBody IdentifiersDto providerIdentifiersDto) {
        pcmService.saveProviders(providerIdentifiersDto);
    }

    @DeleteMapping("/providers/{providerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProvider(@PathVariable Long providerId) {
        pcmService.deleteProvider(providerId);
    }

    @PostMapping("/consents")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveConsent(@Valid @RequestBody ConsentDto consentDto) {
        pcmService.saveConsent(consentDto);
    }

    @DeleteMapping("/consents/{consentId}")
    public void deleteConsent(@PathVariable Long consentId) {
        pcmService.deleteConsent(consentId);
    }

    @PutMapping("/consents/{consentId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateConsent(@PathVariable Long consentId,
                              @Valid @RequestBody ConsentDto consentDto) {
        pcmService.updateConsent(consentId, consentDto);
    }

    @PutMapping("/consents/{consentId}/attestation")
    @ResponseStatus(HttpStatus.OK)
    public void attestConsent(@PathVariable Long consentId,
                              @Valid @RequestBody ConsentAttestationDto consentAttestationDto) {
        pcmService.attestConsent(consentId, consentAttestationDto);
    }
}