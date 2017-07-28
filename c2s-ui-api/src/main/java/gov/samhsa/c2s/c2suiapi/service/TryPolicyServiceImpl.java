package gov.samhsa.c2s.c2suiapi.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import gov.samhsa.c2s.c2suiapi.infrastructure.TryPolicyClient;
import gov.samhsa.c2s.c2suiapi.service.exception.TryPolicyClientInterfaceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TryPolicyServiceImpl implements TryPolicyService {
    private final TryPolicyClient tryPolicyClient;

    public TryPolicyServiceImpl(TryPolicyClient tryPolicyClient) {
        this.tryPolicyClient = tryPolicyClient;
    }

    @Override
    public Object getSegmentDocXHTML(String patientId, String consentId, String documentId, String purposeOfUse) {
        Object tryPolicyResponse;
        try {
            tryPolicyResponse = tryPolicyClient.tryPolicyByConsentIdXHTML(patientId, consentId, documentId, purposeOfUse, LocaleContextHolder.getLocale());
        } catch (HystrixRuntimeException err) {
            log.error("Unexpected instance of HystrixRuntimeException has occurred: ", err);
            throw new TryPolicyClientInterfaceException("An unknown error occurred while attempting to communicate with try-policy service");
        }
        return tryPolicyResponse;
    }
}
