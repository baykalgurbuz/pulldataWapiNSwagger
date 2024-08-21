package com.pulldataNswagger.controllers;

import com.pulldataNswagger.services.CalculatorClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Add Operation",description = "Add two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added succesfull"),
            @ApiResponse(responseCode = "404", description = "Added not succesfull")
    })
    @GetMapping("/add")
    public int add(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.add(firstValue, secondValue);
    }
    @Operation(summary = "Substract Operation",description = "Substract two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Substract succesfull"),
            @ApiResponse(responseCode = "404", description = "Substract not succesfull")
    })
    @GetMapping("/subtract")
    public int subtract(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.subtract(firstValue, secondValue);
    }
    @Operation(summary = "Multiply Operation",description = "Multiply two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Multiply succesfull"),
            @ApiResponse(responseCode = "404", description = "Multiply not succesfull")
    })
    @GetMapping("/multiply")
    public int multiply(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.multiply(firstValue, secondValue);
    }
    @Operation(summary = "Divide Operation",description = "Divide two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Divide succesfull"),
            @ApiResponse(responseCode = "404", description = "Divide not succesfull")
    })
    @GetMapping("/divide")
    public int divide(@RequestParam int firstValue, @RequestParam int secondValue) {
        return calculatorClient.divide(firstValue, secondValue);
    }
}
