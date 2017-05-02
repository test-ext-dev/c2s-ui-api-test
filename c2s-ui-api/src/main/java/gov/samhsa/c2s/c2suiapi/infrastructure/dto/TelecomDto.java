package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

@Data
public class TelecomDto {
    private String system;

    private String value;

    private String use;
}
