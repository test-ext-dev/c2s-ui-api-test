package gov.samhsa.c2s.c2suiapi.service;

import feign.FeignException;
import gov.samhsa.c2s.c2suiapi.infrastructure.PhrClient;
import gov.samhsa.c2s.c2suiapi.service.exception.NoDocumentsFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhrServiceImpl implements PhrService{

    private final PhrClient phrClient;


    @Autowired
    public PhrServiceImpl(PhrClient phrClient) {
        this.phrClient = phrClient;
    }

    @Override
    public List<Object> getAllDocumentTypeCodesList(){
        return phrClient.getAllDocumentTypeCodesList();
    }

    @Override
    public List<Object> getPatientDocumentInfoList(String patientMrn){
        try{
            return phrClient.getPatientDocumentInfoList(patientMrn);
        }catch (FeignException fe){
            if(fe.status() == 404){
                throw new NoDocumentsFoundException(fe.getMessage());
            }
        }
        return null;
    }

}
