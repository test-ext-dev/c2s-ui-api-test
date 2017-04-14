package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDto {
    @NotEmpty
    private List<String> locales;

    @NotNull
    private String defaultLocale;
}
