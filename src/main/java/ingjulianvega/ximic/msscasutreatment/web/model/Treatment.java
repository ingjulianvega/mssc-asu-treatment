package ingjulianvega.ximic.msscasutreatment.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Treatment implements Serializable {

    static final long serialVersionUID = -6929603752029308934L;

    @NotNull
    private UUID visitId;
    @NotNull
    private UUID medicineId;
    @NotBlank
    private int concentrationQuantity;
    @NotNull
    private UUID concentrationId;
    @NotNull
    private UUID administrationMethodId;
    @NotBlank
    private int durationQuantity;
    @NotNull
    private UUID durationId;
    @NotBlank
    private String observations;

}
