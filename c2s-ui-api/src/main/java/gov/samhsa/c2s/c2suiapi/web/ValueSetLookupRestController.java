package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.ValueSetService;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ValueSetCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vss")
public class ValueSetLookupRestController {

    private ValueSetService valueSetService;

    @Autowired
    public ValueSetLookupRestController(ValueSetService valueSetService) {
        this.valueSetService = valueSetService;
    }

    @RequestMapping(value = "/valueSetCategories", method = RequestMethod.GET)
    public List<ValueSetCategoryDto> getValueSetCategories() {
        return valueSetService.getValueSetCategories();
    }
}