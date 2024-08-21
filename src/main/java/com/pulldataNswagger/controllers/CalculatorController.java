package com.pulldataNswagger.controllers;

import com.pulldataNswagger.services.CalculatorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/soap")
public class CalculatorController {
    @Autowired
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }
    @Operation(summary = "Add Operation",description = "Add two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added succesfull"),
            @ApiResponse(responseCode = "404", description = "Added not succesfull")
    })
    @GetMapping("/add")
    public ResponseEntity<Integer> add(@RequestParam int firstValue, @RequestParam int secondValue) {
        return ResponseEntity.ok(calculatorService.add(firstValue, secondValue));
    }
    @Operation(summary = "Substract Operation",description = "Substract two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Substract succesfull"),
            @ApiResponse(responseCode = "404", description = "Substract not succesfull")
    })
    @GetMapping("/subtract")
    public ResponseEntity<Integer> subtract(@RequestParam int firstValue, @RequestParam int secondValue) {
        return ResponseEntity.ok(calculatorService.subtract(firstValue, secondValue));
    }
    @Operation(summary = "Multiply Operation",description = "Multiply two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Multiply succesfull"),
            @ApiResponse(responseCode = "404", description = "Multiply not succesfull")
    })
    @GetMapping("/multiply")
    public ResponseEntity<Integer> multiply(@RequestParam int firstValue, @RequestParam int secondValue) {
        return ResponseEntity.ok(calculatorService.multiply(firstValue, secondValue));
    }
    @Operation(summary = "Divide Operation",description = "Divide two number")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Divide succesfull"),
            @ApiResponse(responseCode = "404", description = "Divide not succesfull")
    })
    @GetMapping("/divide")
    public ResponseEntity<Integer> divide(@RequestParam int firstValue, @RequestParam int secondValue) {
        if (secondValue == 0) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(calculatorService.divide(firstValue, secondValue));

    }
}
