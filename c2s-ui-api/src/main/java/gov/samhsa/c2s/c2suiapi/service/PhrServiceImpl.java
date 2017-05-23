package gov.samhsa.c2s.c2suiapi.service;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import gov.samhsa.c2s.c2suiapi.infrastructure.PhrClient;
import gov.samhsa.c2s.c2suiapi.service.exception.NoDocumentsFoundException;
import gov.samhsa.c2s.c2suiapi.service.exception.PhrClientInterfaceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PhrServiceImpl implements PhrService {

    private final PhrClient phrClient;

    @Autowired
    public PhrServiceImpl(PhrClient phrClient) {
        this.phrClient = phrClient;
    }

    @Override
    public List<Object> getAllDocumentTypeCodesList() {
        return phrClient.getAllDocumentTypeCodesList();
    }

    @Override
    public List<Object> getPatientDocumentInfoList(String patientMrn) {
        List<Object> uploadedDocuments;
        try {
            uploadedDocuments = phrClient.getPatientDocumentInfoList(patientMrn);
        } catch (HystrixRuntimeException err) {
            Throwable t = err.getCause();
            if (t instanceof FeignException && ((FeignException) t).status() == 404) {
                throw new NoDocumentsFoundException(t.getMessage());
            } else {
                log.error("Unexpected instance of HystrixRuntimeException has occurred: ", err);
                throw new PhrClientInterfaceException(err.getCause().getMessage());
            }
        }
        return uploadedDocuments;
    }

}
