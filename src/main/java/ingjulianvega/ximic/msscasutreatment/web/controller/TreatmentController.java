package ingjulianvega.ximic.msscasutreatment.web.controller;


import ingjulianvega.ximic.msscasutreatment.services.TreatmentService;
import ingjulianvega.ximic.msscasutreatment.web.model.Treatment;
import ingjulianvega.ximic.msscasutreatment.web.model.TreatmentDto;
import ingjulianvega.ximic.msscasutreatment.web.model.TreatmentList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class TreatmentController implements TreatmentI {

    private final TreatmentService treatmentService;

    @Override
    public ResponseEntity<TreatmentList> get() {
        return new ResponseEntity<>(treatmentService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TreatmentDto> getById(@NotNull UUID id) {
        return new ResponseEntity<>(treatmentService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TreatmentList> getByVisittId(UUID visitId) {
        return new ResponseEntity<>(treatmentService.getByVisitId(visitId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(@NotNull @Valid Treatment treatment) {
        treatmentService.create(treatment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(@NotNull UUID id, @NotNull @Valid Treatment treatment) {
        treatmentService.updateById(id, treatment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(@NotNull UUID id) {
        treatmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
