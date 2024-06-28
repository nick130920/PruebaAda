package com.ada.prueba.controller;

import com.ada.prueba.dto.OperationDTO;
import com.ada.prueba.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping
    public ResponseEntity<Double> calculate(@RequestBody OperationDTO request) {
        double result;
        try {
            result = calculatorService.calculate(request.getOperation(), request.getOperand1(), request.getOperand2());
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
