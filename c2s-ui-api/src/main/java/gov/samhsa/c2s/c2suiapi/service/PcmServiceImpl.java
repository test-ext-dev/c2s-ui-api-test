package gov.samhsa.c2s.c2suiapi.service;

import gov.samhsa.c2s.c2suiapi.infrastructure.PatientUserClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.PcmClient;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.IdentifiersDto;
import gov.samhsa.c2s.c2suiapi.infrastructure.dto.PcmFlattenedSmallProviderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PcmServiceImpl implements PcmService {
    private static final Long USER_ID = 3L;

    @Autowired
    private PatientUserClient patientUserClient;

    @Autowired
    private PcmClient pcmClient;

    @Override
    public List<PcmFlattenedSmallProviderDto> getProviders() {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        return pcmClient.getProviders(patientId);
    }

    @Override
    public void saveProviders(IdentifiersDto providerIdentifiersDto) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.saveProviders(patientId, providerIdentifiersDto);
    }

    @Override
    public void deleteProvider(Long providerId) {
        Long patientId = patientUserClient.getPatientProfile(USER_ID).getId();
        pcmClient.deleteProvider(patientId, providerId);
    }
}