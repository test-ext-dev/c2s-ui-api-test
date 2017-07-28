package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

@Data
public class SampleDocDto {
    private int id;
    private boolean isSampleDocument;
    private String documentName;
    private String filePath;
}