package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.SampleDocDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;

@FeignClient("try-policy")
public interface TryPolicyClient {
    @RequestMapping(value = "/tryPolicyXHTML/{patientId}", method = RequestMethod.GET)
    Object tryPolicyByConsentIdXHTML(@PathVariable("patientId") String patientId,
                                     @RequestParam("consentId") String consentId,
                                     @RequestParam("documentId") String documentId,
                                     @RequestParam("purposeOfUseCode") String purposeOfUseCode,
                                     @RequestHeader("Accept-Language") Locale locale);

    @RequestMapping(value = "/sampleDocuments", method = RequestMethod.GET)
    List<SampleDocDto> getSampleDocuments();
}
