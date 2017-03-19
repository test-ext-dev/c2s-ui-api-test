package gov.samhsa.c2s.c2suiapi.infrastructure;

import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PatientDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "patientUser")
public interface PatientUserClient {

    // FIXME: call actual patientUser service instead of returning mock data after patientUser is adjusted as a core service
    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    default PatientDto getPatientProfile(@PathVariable("userId") Long userId) {
        return PatientDto.builder()
                .id(4L)
                .firstName("alice")
                .email("alice.recruit@mailinator.com")
                .build();
    }
}