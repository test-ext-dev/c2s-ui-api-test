package gov.samhsa.c2s.c2suiapi.infrastructure;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@FeignClient("try-policy")
public interface TryPolicyClient {
    @RequestMapping(value = "/tryPolicyXHTML", method = RequestMethod.GET)
    Object tryPolicyByConsentIdXHTML(@RequestParam("documentId") String documentId,
                                                       @RequestParam("consentId") String consentId,
                                                       @RequestParam("patientId") String patientId,
                                                       @RequestParam("purposeOfUseCode") String purposeOfUseCode,
                                                       @RequestHeader("Accept-Language") Locale locale);
}
