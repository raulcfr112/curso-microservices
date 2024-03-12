package io.github.raulcfr112.restwithspringboot.validations;

public interface OperationValidations {
    Double convertToDouble(String strNumber);
    Boolean isNumeric  (String strNumber);
}

