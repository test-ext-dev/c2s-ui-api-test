package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;

@Data
public class BaseUmsLookupDto {
    String code;

    String displayName;

    String description;

    String codeSystem;

    String codeSystemOID;

    String codeSystemName;
}
