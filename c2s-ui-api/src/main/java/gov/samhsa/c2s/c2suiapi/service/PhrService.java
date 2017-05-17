package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.service.dto.UploadedDocumentInfoDto;

import java.util.List;

public interface PhrService {

    List<UploadedDocumentInfoDto> getPatientDocumentInfoList(String patientMrn);
}
