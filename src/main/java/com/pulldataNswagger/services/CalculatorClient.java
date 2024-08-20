package com.pulldataNswagger.services;

import com.example.calculator.Calculator;
import com.example.calculator.CalculatorSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorClient {
    private final CalculatorSoap calculatorSoap;
    @Autowired
    public CalculatorClient() {
        try {
            Calculator calculator = new Calculator();
            this.calculatorSoap = calculator.getCalculatorSoap();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize CalculatorSoap", e);
        }
    }

    public int add(int a, int b) {
        return calculatorSoap.add(a, b);
    }

    public int subtract(int a, int b) {
        return calculatorSoap.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return calculatorSoap.multiply(a, b);
    }

    public int divide(int a, int b) {
        return calculatorSoap.divide(a, b);
    }
}
