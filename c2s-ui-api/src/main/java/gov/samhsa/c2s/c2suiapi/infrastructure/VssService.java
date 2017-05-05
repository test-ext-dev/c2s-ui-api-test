package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ValueSetCategoryDto;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

public interface VssService {
    @RequestMapping(value = "/valueSetCategories", method = RequestMethod.GET)
    List<ValueSetCategoryDto> getValueSetCategories(@RequestHeader("Accept-Language") Locale locale);
}