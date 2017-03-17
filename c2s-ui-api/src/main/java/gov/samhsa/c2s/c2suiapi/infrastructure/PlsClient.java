package gov.samhsa.c2s.c2suiapi.infrastructure;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("pls")
public interface PlsClient extends PlsService {
}