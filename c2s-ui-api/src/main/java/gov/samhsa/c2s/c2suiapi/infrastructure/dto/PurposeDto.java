package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class PurposeDto {
    private String description;
    private String display;
    @NotNull
    private Long id;

    @Valid
    @NotNull
    @JsonUnwrapped
    private IdentifierDto identifier;
}
