package ingjulianvega.ximic.msscasutreatment.services;


import ingjulianvega.ximic.msscasutreatment.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasutreatment.domain.TreatmentEntity;
import ingjulianvega.ximic.msscasutreatment.domain.repositories.TreatmentRepository;
import ingjulianvega.ximic.msscasutreatment.exception.TreatmentException;
import ingjulianvega.ximic.msscasutreatment.web.Mappers.TreatmentMapper;
import ingjulianvega.ximic.msscasutreatment.web.model.Treatment;
import ingjulianvega.ximic.msscasutreatment.web.model.TreatmentDto;
import ingjulianvega.ximic.msscasutreatment.web.model.TreatmentList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository treatmentRepository;
    private final TreatmentMapper treatmentMapper;

    @Cacheable(cacheNames = "treatmentListCache")
    @Override
    public TreatmentList get() {
        log.debug("get()...");
        return TreatmentList
                .builder()
                .treatmentDtoList(treatmentMapper.treatmentEntityListToTreatmentDtoList(treatmentRepository.findAll()))
                .build();
    }

    @Cacheable(cacheNames = "treatmentCache")
    @Override
    public TreatmentDto getById(UUID id) {
        log.debug("getById()...");
        return treatmentMapper.treatmentEntityToTreatmentDto(
                treatmentRepository.findById(id)
                        .orElseThrow(() -> new TreatmentException(ErrorCodeMessages.TREATMENT_NOT_FOUND, "")));
    }

    @Override
    public TreatmentList getByVisitId(UUID visitId) {
        log.debug("getByVisitId()...");
        return TreatmentList
                .builder()
                .treatmentDtoList(treatmentMapper.treatmentEntityListToTreatmentDtoList(treatmentRepository.findByVisitId(visitId)))
                .build();
    }

    @Override
    public void create(Treatment treatment) {
        log.debug("create()...");
        treatmentMapper.treatmentEntityToTreatmentDto(
                treatmentRepository.save(
                        treatmentMapper.treatmentDtoToTreatmentEntity(
                                TreatmentDto
                                        .builder()
                                        .visitId(treatment.getVisitId())
                                        .medicineId(treatment.getMedicineId())
                                        .concentrationQuantity(treatment.getConcentrationQuantity())
                                        .administrationMethodId(treatment.getAdministrationMethodId())
                                        .durationQuantity(treatment.getDurationQuantity())
                                        .durationId(treatment.getDurationId())
                                        .observations(treatment.getObservations())
                                        .build())));
    }

    @Override
    public void updateById(UUID id, Treatment treatment) {
        log.debug("updateById...");
        TreatmentEntity treatmentEntity = treatmentRepository.findById(id)
                .orElseThrow(() -> new TreatmentException(ErrorCodeMessages.TREATMENT_NOT_FOUND, ""));

        treatmentEntity.setVisitId(treatment.getVisitId());
        treatmentEntity.setMedicineId(treatment.getMedicineId());
        treatmentEntity.setConcentrationQuantity(treatment.getConcentrationQuantity());
        treatmentEntity.setAdministrationMethodId(treatment.getAdministrationMethodId());
        treatmentEntity.setDurationQuantity(treatment.getDurationQuantity());
        treatmentEntity.setDurationId(treatment.getDurationId());
        treatmentEntity.setObservations(treatment.getObservations());

        treatmentRepository.save(treatmentEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        treatmentRepository.deleteById(id);
    }
}
