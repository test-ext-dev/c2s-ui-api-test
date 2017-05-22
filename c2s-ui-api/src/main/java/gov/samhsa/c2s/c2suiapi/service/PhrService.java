package gov.samhsa.c2s.c2suiapi.service;

import java.util.List;

public interface PhrService {

    List<Object> getAllDocumentTypeCodesList();

    List<Object> getPatientDocumentInfoList(String patientMrn);

    Object getPatientDocumentByDocId(String patientMrn, Long id);

    void deletePatientDocument(String patientMrn, Long id);
}
