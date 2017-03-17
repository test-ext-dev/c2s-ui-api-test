package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.PlsClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.PlsService;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pls")
public class PlsRestController implements PlsService {

    @Autowired
    private PlsClient plsClient;

    @Override
    public PagedResources<FlattenedSmallProviderDto> getFlattenedSmallProviderDto(
            @RequestParam(value = "projection") String projection) {
        return plsClient.getFlattenedSmallProviderDto(projection);
    }
}