package ingjulianvega.ximic.msscasutreatment.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class TreatmentEntity extends BaseEntity {

    private UUID visitId;
    private UUID medicineId;
    private int concentrationQuantity;
    private UUID administrationMethodId;
    private int durationQuantity;
    private UUID durationId;
    private String observations;
}
