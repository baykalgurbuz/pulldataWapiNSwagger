package com.pulldataNswagger.controllers;

import com.pulldataNswagger.services.CalculatorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soap")
public class CalculatorController {
    @Autowired
    private final CalculatorClient calculatorClient;

    public CalculatorController(CalculatorClient calculatorClient) {
        this.calculatorClient = calculatorClient;
    }
    @GetMapping("/add")
    public int add(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.add(firstValue, secondValue);
    }

    @GetMapping("/subtract")
    public int subtract(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.subtract(firstValue, secondValue);
    }

    @GetMapping("/multiply")
    public int multiply(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.multiply(firstValue, secondValue);
    }

    @GetMapping("/divide")
    public int divide(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.divide(firstValue, secondValue);
    }
}
