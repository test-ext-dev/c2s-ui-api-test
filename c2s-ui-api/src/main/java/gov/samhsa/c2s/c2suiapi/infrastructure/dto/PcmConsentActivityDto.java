package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

@Data
public class PcmConsentActivityDto {
    private String consentReferenceId;
    private String actionType;
    private String updatedBy;
    private String updatedDateTime;
    private RoleDto role;
}
