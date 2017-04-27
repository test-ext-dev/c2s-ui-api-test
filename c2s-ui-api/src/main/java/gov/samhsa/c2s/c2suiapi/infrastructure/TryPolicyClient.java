package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.TryPolicyDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface TryPolicyClient {
    @RequestMapping(value = "/tryPolicyXHTML", method = RequestMethod.GET)
    public TryPolicyDto tryPolicyByConsentIdXHTML(@RequestParam("documentId") String documentId,
                                                  @RequestParam("consentId") String consentId,
                                                  @RequestParam("patientId") String patientId,
                                                  @RequestParam("purposeOfUseCode") String purposeOfUseCode);
}
