package ingjulianvega.ximic.msscasutreatment.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TreatmentList implements Serializable {

    static final long serialVersionUID = 1032920440101196621L;

    public ArrayList<TreatmentDto> treatmentDtoList;
}
