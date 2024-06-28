package com.ada.prueba.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot take the square root of a negative number");
        }
        return Math.sqrt(a);
    }

    public double calculate(String operation, double operand1, double operand2) {
        return switch (operation.toLowerCase()) {
            case "add" -> add(operand1, operand2);
            case "subtract" -> subtract(operand1, operand2);
            case "multiply" -> multiply(operand1, operand2);
            case "divide" -> divide(operand1, operand2);
            case "sqrt" -> sqrt(operand1); // Ignore operand2 for sqrt
            default -> throw new IllegalArgumentException("Invalid operation: " + operation);
        };
    }
}
