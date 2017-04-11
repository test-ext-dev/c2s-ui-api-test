package gov.samhsa.c2s.c2suiapi.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "c2s.ums")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UmsProperties {
    @NotEmpty
    private List<String> supportedLocales = new ArrayList<>();
    @NotNull
    private String defaultLocale;
}
