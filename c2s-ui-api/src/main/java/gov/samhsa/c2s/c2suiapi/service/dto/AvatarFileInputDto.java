package gov.samhsa.c2s.c2suiapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AvatarFileInputDto {
    private String fileContents;   // this is a Base64 encoded string
    private String fileExtension;
    private String fileName;
    private Long fileSizeBytes;
    private Long fileWidthPixels;
    private Long fileHeightPixels;
}
