package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.PhrClient;
import gov.samhsa.c2s.c2suiapi.service.dto.UploadedDocumentInfoDto;
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
    public List<UploadedDocumentInfoDto> getPatientDocumentInfoList(String patientMrn){
        return phrClient.getPatientDocumentInfoList(patientMrn);
    }

}
