package gov.samhsa.c2s.c2suiapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConsentActivityDto {
    private String consentReferenceId;
    private String actionType;
    private String updatedBy;
    private String updatedDateTime;
    private String role;
}
