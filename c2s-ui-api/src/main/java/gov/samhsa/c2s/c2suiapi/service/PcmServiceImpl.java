package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.PcmClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PcmFlattenedSmallProviderDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcmServiceImpl implements PcmService {
    private static final Long PATIENT_ID = 4L;

    @Autowired
    private PcmClient pcmClient;

    @Override
    public List<PcmFlattenedSmallProviderDto> getProviders() {
        return pcmClient.getProviders(PATIENT_ID);
    }

    @Override
    public void saveProviders(IdentifiersDto providerIdentifiersDto) {
        pcmClient.saveProviders(PATIENT_ID, providerIdentifiersDto);
    }

    @Override
    public void deleteProvider(Long providerId) {
        pcmClient.deleteProvider(PATIENT_ID, providerId);
    }
}