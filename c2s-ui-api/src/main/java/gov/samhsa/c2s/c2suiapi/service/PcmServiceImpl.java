package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.PcmClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.FlattenedSmallProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcmServiceImpl implements PcmService {
    @Autowired
    private PcmClient pcmClient;

    @Override
    public List<FlattenedSmallProviderDto> getProviders() {
        Long patientId = 4L;
        return pcmClient.getProviders(patientId);
    }
}