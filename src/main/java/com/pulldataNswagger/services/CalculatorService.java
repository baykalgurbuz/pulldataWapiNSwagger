package com.pulldataNswagger.services;

import com.example.calculator.Calculator;
import com.example.calculator.CalculatorSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    private final CalculatorSoap calculatorSoap;
    @Autowired
    public CalculatorService() {
        try {
            Calculator calculator = new Calculator();
            this.calculatorSoap = calculator.getCalculatorSoap();
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize CalculatorSoap", e);
        }
    }

    public int add(int firstValue, int secondValue) {
        return calculatorSoap.add(firstValue, secondValue);
    }

    public int subtract(int firstValue, int secondValue) {
        return calculatorSoap.subtract(firstValue, secondValue);
    }

    public int multiply(int firstValue, int secondValue) {
        return calculatorSoap.multiply(firstValue, secondValue);
    }

    public int divide(int firstValue, int secondValue) {
        if (secondValue == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return firstValue / secondValue;
    }
}
