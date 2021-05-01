package ingjulianvega.ximic.msscasutreatment.services;


import ingjulianvega.ximic.msscasutreatment.web.model.Treatment;
import ingjulianvega.ximic.msscasutreatment.web.model.TreatmentDto;
import ingjulianvega.ximic.msscasutreatment.web.model.TreatmentList;

import java.util.UUID;

public interface TreatmentService {
    TreatmentList get();

    TreatmentDto getById(UUID id);

    TreatmentList getByVisitId(UUID patientId);

    void create(Treatment treatment);

    void updateById(UUID id, Treatment treatment);

    void deleteById(UUID id);


}
