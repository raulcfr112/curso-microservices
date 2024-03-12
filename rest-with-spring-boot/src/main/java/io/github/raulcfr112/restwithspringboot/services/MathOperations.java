package io.github.raulcfr112.restwithspringboot.services;

import io.github.raulcfr112.restwithspringboot.exceptions.UnsupportedMathOperationException;
import io.github.raulcfr112.restwithspringboot.validations.OperationValidationsImp;
import org.springframework.stereotype.Service;

@Service
public class MathOperations {

    private static OperationValidationsImp op = new OperationValidationsImp();


    public Double sum(String numberOne, String numberTwo) throws Exception {
        if (!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return op.convertToDouble(numberOne) + op.convertToDouble(numberTwo);
    }

    public Double sub(String numberOne, String numberTwo) throws Exception {
        if (!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return op.convertToDouble(numberOne) - op.convertToDouble(numberTwo);
    }

    public Double mult(
            String numberOne, String numberTwo) throws Exception {
        if (!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return op.convertToDouble(numberOne) * op.convertToDouble(numberTwo);
    }

    public Double div(
            String numberOne, String numberTwo) throws Exception {
        if (!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return op.convertToDouble(numberOne) / op.convertToDouble(numberTwo);
    }

    public Double average(String numberOne, String numberTwo) throws Exception {
        if (!op.isNumeric(numberOne) || !op.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return ((op.convertToDouble(numberOne) + op.convertToDouble(numberTwo)) / 2);
    }

    public Double square(String numberOne) throws Exception {
        if (!op.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return Math.sqrt(op.convertToDouble(numberOne));
    }

}
