package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.PhrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class PhrRestController {
    private final PhrService phrService;

    @Autowired
    public PhrRestController(PhrService phrService) {
        this.phrService = phrService;
    }

    @GetMapping("/uploadedDocuments/patient/{patientMrn}/documentsList")
    public List<Object> getPatientDocumentsList(@PathVariable String patientMrn){
        return phrService.getPatientDocumentInfoList(patientMrn);
    }
}
