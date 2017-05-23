package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.config.MultipartSupportConfig;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "phr", configuration = MultipartSupportConfig.class)
@Service
public interface PhrClient {

    @RequestMapping(value = "/uploadedDocuments/documentTypeCodes", method = RequestMethod.GET)
    List<Object> getAllDocumentTypeCodesList();

    @RequestMapping(value = "/uploadedDocuments/patients/{patientMrn}/documents", method = RequestMethod.GET)
    List<Object> getPatientDocumentInfoList(@PathVariable("patientMrn") String patientId);

    @RequestMapping(value = "/uploadedDocuments/patients/{patientMrn}/documents/{id}", method = RequestMethod.GET)
    Object getPatientDocumentByDocId(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id);

    @RequestMapping(value = "/uploadedDocuments/patients/{patientMrn}/documents/{id}", method = RequestMethod.DELETE)
    void deletePatientDocument(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id);
}
