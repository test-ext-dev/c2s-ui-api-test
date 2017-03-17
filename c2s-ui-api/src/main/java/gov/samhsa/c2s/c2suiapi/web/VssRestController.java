package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.VssClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.VssService;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ValueSetCategoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vss")
public class VssRestController implements VssService {

    @Autowired
    private VssClient vssClient;

    @Override
    public List<ValueSetCategoryDto> getValueSetCategories() {
        return vssClient.getValueSetCategories();
    }
}