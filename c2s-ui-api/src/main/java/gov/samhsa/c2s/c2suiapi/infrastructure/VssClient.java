package gov.samhsa.c2s.c2suiapi.infrastructure;

import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("vss")
public interface VssClient extends VssService {
}