package ingjulianvega.ximic.msscasutreatment.bootstrap;

import ingjulianvega.ximic.msscasutreatment.domain.TreatmentEntity;
import ingjulianvega.ximic.msscasutreatment.domain.repositories.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class TreatmentLoader implements CommandLineRunner {

    private final TreatmentRepository treatmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (treatmentRepository.count() == 0) {
            loadTreatmentObjects();
        }
    }

    private void loadTreatmentObjects() {
        treatmentRepository.saveAll(Arrays.asList(
                TreatmentEntity.builder()
                        .visitId(UUID.randomUUID())
                        .medicineId(UUID.randomUUID())
                        .concentrationQuantity(1)
                        .concentrationId(UUID.randomUUID())
                        .administrationMethodId(UUID.randomUUID())
                        .durationQuantity(1)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                TreatmentEntity.builder()
                        .visitId(UUID.randomUUID())
                        .medicineId(UUID.randomUUID())
                        .concentrationQuantity(2)
                        .concentrationId(UUID.randomUUID())
                        .administrationMethodId(UUID.randomUUID())
                        .durationQuantity(2)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                TreatmentEntity.builder()
                        .visitId(UUID.randomUUID())
                        .medicineId(UUID.randomUUID())
                        .concentrationQuantity(3)
                        .concentrationId(UUID.randomUUID())
                        .administrationMethodId(UUID.randomUUID())
                        .durationQuantity(3)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                TreatmentEntity.builder()
                        .visitId(UUID.randomUUID())
                        .medicineId(UUID.randomUUID())
                        .concentrationQuantity(4)
                        .concentrationId(UUID.randomUUID())
                        .administrationMethodId(UUID.randomUUID())
                        .durationQuantity(4)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build(),
                TreatmentEntity.builder()
                        .visitId(UUID.randomUUID())
                        .medicineId(UUID.randomUUID())
                        .concentrationQuantity(5)
                        .concentrationId(UUID.randomUUID())
                        .administrationMethodId(UUID.randomUUID())
                        .durationQuantity(5)
                        .durationId(UUID.randomUUID())
                        .observations("observación").build()
        ));
    }
}