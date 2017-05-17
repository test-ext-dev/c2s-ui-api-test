package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.service.dto.UploadedDocumentInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("phr")
@Service
public interface PhrClient {

    @RequestMapping(value = "/uploadedDocuments/patient/{patientMrn}/documentsList", method = RequestMethod.GET)
    List<UploadedDocumentInfoDto> getPatientDocumentInfoList(@PathVariable("patientMrn") String patientId);

}
