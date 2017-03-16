package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ValueSetCategoryDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface VssContract {
    @RequestMapping(value = "/valueSetCategories", method = RequestMethod.GET)
    List<ValueSetCategoryDto> getValueSetCategories();
}
