package gov.samhsa.c2s.c2suiapi.service;

import feign.FeignException;
import gov.samhsa.c2s.c2suiapi.infrastructure.TryPolicyClient;
import gov.samhsa.c2s.c2suiapi.service.dto.TryPolicyResponse;
import gov.samhsa.c2s.c2suiapi.service.exception.NoDocumentsFoundException;
import gov.samhsa.c2s.c2suiapi.service.exception.TryPolicyException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class TryPolicyServiceImpl implements TryPolicyService {
    private final TryPolicyClient tryPolicyClient;

    public TryPolicyServiceImpl(TryPolicyClient tryPolicyClient) {
        this.tryPolicyClient = tryPolicyClient;
    }

    @Override
    public TryPolicyResponse getSegmentDocXHTML(String documentId, String consentId, String patientId, String purposeOfUse, Locale locale) {
       try{
           return tryPolicyClient.tryPolicyByConsentIdXHTML(documentId, consentId, patientId, purposeOfUse, locale);
       }catch (FeignException fe){
           if(fe.status() == 404){
               throw new NoDocumentsFoundException(fe.getMessage());
           } else throw new TryPolicyException("Unknown Exception");
       }
    }
}
