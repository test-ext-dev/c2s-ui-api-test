package gov.samhsa.c2s.c2suiapi.service.dto;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.BaseUmsLookupDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private String userLocale;
    private List<BaseUmsLookupDto> supportedLocales;
    private String username;
    private String lastName;
    private String firstName;
    private String mrn;
    private LocalDate birthDate;
}
