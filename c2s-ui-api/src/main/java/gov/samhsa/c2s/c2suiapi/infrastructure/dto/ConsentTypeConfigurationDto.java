package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class ConsentTypeConfigurationDto {
    @NotNull
    private boolean shareConsentTypeConfigured;
}
