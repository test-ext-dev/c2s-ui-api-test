package gov.samhsa.c2s.c2suiapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {
    private String userLocale;
    private List<String> supportedLocales;
    private String username;
    private String lastName;
    private String firstName;
    private String mrn;
}
