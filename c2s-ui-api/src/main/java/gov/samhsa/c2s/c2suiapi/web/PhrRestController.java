package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.service.phr.PhrUploadedDocumentsService;
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
    private final PhrUploadedDocumentsService phrUploadedDocumentsService;

    @Autowired
    public PhrRestController(PhrUploadedDocumentsService phrUploadedDocumentsService) {
        this.phrUploadedDocumentsService = phrUploadedDocumentsService;
    }


    @GetMapping("/uploadedDocuments/documentTypeCodes")
    public List<Object> getAllDocumentTypeCodesList() {
        return phrUploadedDocumentsService.getAllDocumentTypeCodesList();
    }

    @GetMapping("/uploadedDocuments/patients/{patientMrn}/documents")
    public Object getPatientDocumentsList(@PathVariable String patientMrn) {
        return phrUploadedDocumentsService.getPatientDocumentInfoList(patientMrn);
    }

    @GetMapping("/uploadedDocuments/patients/{patientMrn}/documents/{id}")
    public Object getPatientDocumentByDocId(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id) {
        return phrUploadedDocumentsService.getPatientDocumentByDocId(patientMrn, id);
    }

    @PostMapping("/uploadedDocuments/patients/{patientMrn}/documents")
    public Object saveNewPatientDocument(@PathVariable String patientMrn,
                                         @RequestParam(value = "documentFile") MultipartFile documentFile,
                                         @RequestParam(value = "documentName") String documentName,
                                         @RequestParam(value = "description", required = false) String description,
                                         @RequestParam(value = "documentTypeCodeId") Long documentTypeCodeId) {
        return phrUploadedDocumentsService.saveNewPatientDocument(patientMrn, documentFile, documentName, description, documentTypeCodeId);
    }

    @DeleteMapping("/uploadedDocuments/patients/{patientMrn}/documents/{id}")
    public void deletePatientDocument(@PathVariable("patientMrn") String patientMrn, @PathVariable("id") Long id) {
        phrUploadedDocumentsService.deletePatientDocument(patientMrn, id);
    }
}
