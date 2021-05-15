package ingjulianvega.ximic.msscasutreatment.web.Mappers;


import ingjulianvega.ximic.events.UpdateTreatmentEvent;
import ingjulianvega.ximic.msscasutreatment.domain.TreatmentEntity;
import ingjulianvega.ximic.msscasutreatment.web.model.Treatment;
import ingjulianvega.ximic.msscasutreatment.web.model.TreatmentDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface TreatmentMapper {
    TreatmentDto treatmentEntityToTreatmentDto(TreatmentEntity remissionEntity);

    TreatmentEntity treatmentDtoToTreatmentEntity(TreatmentDto remissionDto);

    ArrayList<TreatmentDto> treatmentEntityListToTreatmentDtoList(List<TreatmentEntity> remissionEntityList);

    Treatment updateTreatmentEventToTreatment(UpdateTreatmentEvent updateTreatmentEvent);

}
