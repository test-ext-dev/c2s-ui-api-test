package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.TryPolicyService;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/try-Policy")
public class TryPolicyRestController {

    private final TryPolicyService tryPolicyService;

    public TryPolicyRestController(TryPolicyService tryPolicyService) {
        this.tryPolicyService = tryPolicyService;
    }

    @RequestMapping(value = "/tryPolicyXHTML", method = RequestMethod.GET)
    public Object tryPolicyByConsentIdXHTML(@RequestParam("documentId") String documentId,
                                                       @RequestParam("consentId") String consentId,
                                                       @RequestParam("patientId") String patientId,
                                                       @RequestParam("purposeOfUseCode") String purposeOfUseCode,
                                                       @RequestHeader("Accept-Language") Locale locale) {
        return tryPolicyService.getSegmentDocXHTML(documentId, consentId, patientId, purposeOfUseCode, locale);
    }

}
