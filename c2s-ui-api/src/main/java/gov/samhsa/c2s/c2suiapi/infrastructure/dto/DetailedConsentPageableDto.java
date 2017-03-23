package gov.samhsa.c2s.c2suiapi.infrastructure.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;

@Data
public class DetailedConsentPageableDto {
    @JsonUnwrapped
    PageableDto<DetailedConsentDto> pageableDto;
}
