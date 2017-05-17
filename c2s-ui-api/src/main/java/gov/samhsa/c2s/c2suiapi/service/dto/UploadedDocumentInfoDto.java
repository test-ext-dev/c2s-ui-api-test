package gov.samhsa.c2s.c2suiapi.service.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

@Data
public class UploadedDocumentInfoDto {
    @NotEmpty
    private Long documentId;

    @NotEmpty
    private String documentFileName;

    @NotEmpty
    private String documentName;

    @NotEmpty
    private String documentContentType;

    private String documentDescription;
}
