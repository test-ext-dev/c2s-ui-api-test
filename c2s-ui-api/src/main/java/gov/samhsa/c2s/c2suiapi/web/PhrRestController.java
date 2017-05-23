package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.PhrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/phr")
public class PhrRestController {
    private final PhrService phrService;

    @Autowired
    public PhrRestController(PhrService phrService) {
        this.phrService = phrService;
    }

    @GetMapping("/uploadedDocuments/documentTypeCodes")
    public List<Object> getAllDocumentTypeCodesList(){
        return phrService.getAllDocumentTypeCodesList();
    }

    @GetMapping("/uploadedDocuments/patients/{patientMrn}/documents")
    public List<Object> getPatientDocumentsList(@PathVariable String patientMrn){
        return phrService.getPatientDocumentInfoList(patientMrn);
    }

    @GetMapping("/uploadedDocuments/patients/{patientMrn}/documents/{id}")
    public Object getPatientDocumentByDocId(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id){
        return phrService.getPatientDocumentByDocId(patientMrn, id);
    }

    @PostMapping("/uploadedDocuments/patients/{patientMrn}/documents")
    public Object saveNewPatientDocument(@PathVariable String patientMrn,
                                         @RequestParam(value = "file") MultipartFile file,
                                         @RequestParam(value = "documentName") String documentName,
                                         @RequestParam(value = "description", required = false) String description,
                                         @RequestParam(value = "documentTypeCodeId") Long documentTypeCodeId){
        return phrService.saveNewPatientDocument(patientMrn, file, documentName, description, documentTypeCodeId);
    }

    @DeleteMapping("/uploadedDocuments/patients/{patientMrn}/documents/{id}")
    public void deletePatientDocument(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id){
        phrService.deletePatientDocument(patientMrn, id);
    }
}
