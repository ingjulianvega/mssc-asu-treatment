package ingjulianvega.ximic.msscasutreatment.listener;

import ingjulianvega.ximic.events.UpdateTreatmentEvent;
import ingjulianvega.ximic.msscasutreatment.configuration.JmsConfig;
import ingjulianvega.ximic.msscasutreatment.services.TreatmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class UpdateTreatmentListener {

    private final TreatmentService treatmentService;

    @JmsListener(destination = JmsConfig.UPDATE_TREATMENT_QUEUE)
    public void listen(UpdateTreatmentEvent event) {
        log.debug("Got updateTreatment " + event.toString());
        //visitService.create(event.getVisit());
    }
}
