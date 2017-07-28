package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.TryPolicyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/try-policy")
public class TryPolicyRestController {

    private final TryPolicyService tryPolicyService;

    public TryPolicyRestController(TryPolicyService tryPolicyService) {
        this.tryPolicyService = tryPolicyService;
    }

    @GetMapping("/tryPolicyXHTML/{patientId}")
    public Object tryPolicyByConsentIdXHTML(@PathVariable("patientId") String patientId,
                                            @RequestParam("consentId") String consentId,
                                            @RequestParam("documentId") String documentId,
                                            @RequestParam("purposeOfUseCode") String purposeOfUseCode) {
        return tryPolicyService.getSegmentDocXHTML(patientId, consentId, documentId, purposeOfUseCode);
    }

}
