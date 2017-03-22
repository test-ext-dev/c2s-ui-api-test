package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PurposeDto {
    private String display;

    @NotNull
    private Long id;

    @NotNull
    private String system;

    @NotNull
    private String value;
}
