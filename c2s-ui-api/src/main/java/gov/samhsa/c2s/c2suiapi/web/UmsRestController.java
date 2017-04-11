package gov.samhsa.c2s.c2suiapi.web;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.ProfileDto;
import gov.samhsa.c2s.c2suiapi.service.UmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ums")
public class UmsRestController {

    @Autowired
    private UmsServiceImpl umsService;

    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileDto setProfile() {
        return umsService.getProfile();
    }
}
