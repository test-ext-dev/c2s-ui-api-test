package gov.samhsa.c2s.c2suiapi.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import gov.samhsa.c2s.c2suiapi.infrastructure.TryPolicyClient;
import gov.samhsa.c2s.c2suiapi.service.exception.TryPolicyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
@Slf4j
public class TryPolicyServiceImpl implements TryPolicyService {
    private final TryPolicyClient tryPolicyClient;

    public TryPolicyServiceImpl(TryPolicyClient tryPolicyClient) {
        this.tryPolicyClient = tryPolicyClient;
    }

    @Override
    public Object getSegmentDocXHTML(String documentId, String consentId, String patientId, String purposeOfUse, Locale locale) {
        Object tryPolicyResponse;
        try {
            tryPolicyResponse = tryPolicyClient.tryPolicyByConsentIdXHTML(documentId, consentId, patientId, purposeOfUse, locale);
        } catch (HystrixRuntimeException err) {
            log.error("Unexpected instance of HystrixRuntimeException has occurred: ", err);
            throw new TryPolicyException(err.getCause().getMessage());
        }
        return tryPolicyResponse;
    }
}
