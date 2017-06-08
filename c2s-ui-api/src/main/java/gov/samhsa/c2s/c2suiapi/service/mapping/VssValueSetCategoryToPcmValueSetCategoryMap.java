package gov.samhsa.c2s.c2suiapi.service.mapping;

import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;


@Component
public class VssValueSetCategoryToPcmValueSetCategoryMap extends PropertyMap<gov.samhsa.c2s.c2suiapi.infrastructure.dto.ValueSetCategoryDto, gov.samhsa.c2s.c2suiapi.service.dto.ValueSetCategoryDto> {

    @Override
    protected void configure() {
        map().setDisplayName(source.getName());
    }
}