package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.VssContract;
import gov.samhsa.c2s.c2suiapi.infrastructure.VssService;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ValueSetCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vss")
public class VSSRestController implements VssContract {

    @Autowired
    private VssService vssService;

    @Override
    public List<ValueSetCategoryDto> getValueSetCategories() {
        return vssService.getValueSetCategories();
    }
}