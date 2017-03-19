package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class PcmFlattenedSmallProviderDto extends PlsFlattenedSmallProviderDto {
    private Long id;
    private String system;
}