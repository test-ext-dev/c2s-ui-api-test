package gov.samhsa.c2s.c2suiapi.service.mapping.customconverter;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.TelecomDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.UmsUserDto;
import gov.samhsa.c2s.c2suiapi.service.mapping.System;
import gov.samhsa.c2s.c2suiapi.service.mapping.Use;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

@Component
public class TelecomsToHomeEmailConverter extends AbstractConverter<UmsUserDto, String> {
    @Override
    protected String convert(UmsUserDto source) {
        return source.getTelecoms().stream()
                .filter(telecomDto -> telecomDto.getSystem().equalsIgnoreCase(System.EMAIL.toString())
                        && telecomDto.getUse().equalsIgnoreCase(Use.HOME.toString()))
                .map(TelecomDto::getValue)
                .findFirst()
                .orElse(null);
    }
}
