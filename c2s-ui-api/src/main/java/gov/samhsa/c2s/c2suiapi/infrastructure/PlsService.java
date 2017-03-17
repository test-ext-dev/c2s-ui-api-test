package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import org.springframework.hateoas.PagedResources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface PlsService {
    @RequestMapping(value = "/providers", method = RequestMethod.GET)
    PagedResources<FlattenedSmallProviderDto> getFlattenedSmallProviderDto(
            @RequestParam(value = "projection") String projection);
}