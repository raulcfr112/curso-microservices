package io.github.raulcfr112.restwithspringboot.controllers;

import io.github.raulcfr112.restwithspringboot.services.MathOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MathController {

    @Autowired
    private MathOperations mathOperations;

    public MathController(MathOperations mathOperations) {
        this.mathOperations = mathOperations;
    }

    @RequestMapping(
            value = "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return mathOperations.sum(numberOne,numberTwo);
    }

    @RequestMapping(
            value = "/sub/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        return mathOperations.sub(numberOne,numberTwo);
    }

    @RequestMapping(
            value = "/mult/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double mult(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) throws Exception{
        return mathOperations.mult(numberOne,numberTwo);
    }
    @RequestMapping(
            value = "/div/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberOne") String numberTwo) throws Exception{
        return mathOperations.div(numberOne,numberTwo);
    }
    @RequestMapping(
            value = "/average/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double average(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberOne") String numberTwo) throws Exception{
        return mathOperations.average(numberOne,numberTwo);
    }
    @RequestMapping(
            value = "/square/{numberOne}",
            method = RequestMethod.GET)
    public Double square(
            @PathVariable("numberOne") String numberOne) throws Exception{
        return mathOperations.square(numberOne);
    }

}
