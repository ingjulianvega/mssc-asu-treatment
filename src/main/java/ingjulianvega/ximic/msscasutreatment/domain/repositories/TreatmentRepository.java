package ingjulianvega.ximic.msscasutreatment.domain.repositories;

import ingjulianvega.ximic.msscasutreatment.domain.TreatmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface TreatmentRepository extends JpaRepository<TreatmentEntity, UUID>, JpaSpecificationExecutor<TreatmentEntity> {
    List<TreatmentEntity> findByVisitId(UUID visitId);
}
