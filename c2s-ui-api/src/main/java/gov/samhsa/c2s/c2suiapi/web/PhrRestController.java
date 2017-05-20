package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.PhrService;
import gov.samhsa.c2s.c2suiapi.service.dto.UploadedDocumentInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class PhrRestController {
    @Autowired
    private PhrService phrService;

    @GetMapping("/uploadedDocuments/patients/{patientMrn}/documents")
    public List<UploadedDocumentInfoDto> getPatientDocumentsList(@PathVariable String patientMrn){
        return phrService.getPatientDocumentInfoList(patientMrn);
    }
}
