package ingjulianvega.ximic.msscasutreatment.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "treatment")
public class TreatmentParameters {

    private String api;
}
