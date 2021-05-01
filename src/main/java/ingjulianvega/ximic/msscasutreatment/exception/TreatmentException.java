package ingjulianvega.ximic.msscasutreatment.exception;

import lombok.Getter;

@Getter
public class TreatmentException extends RuntimeException {

    private final String code;

    public TreatmentException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

