package gov.samhsa.c2s.c2suiapi.service.dto;


import gov.samhsa.c2s.c2suiapi.infrastructure.dto.BaseUmsLookupDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifierSystemDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationLookupDto {
    private List<RoleDto> roles;
    private List<BaseUmsLookupDto> genderCodes;
    private List<BaseUmsLookupDto> stateCodes;
    private List<BaseUmsLookupDto> countryCodes;
    private List<BaseUmsLookupDto> locales;
    private List<IdentifierSystemDto> identifierSystems;
}
