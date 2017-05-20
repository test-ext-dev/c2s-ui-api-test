package gov.samhsa.c2s.c2suiapi.service;

import java.util.List;

public interface PhrService {

    List<Object> getPatientDocumentInfoList(String patientMrn);
}
