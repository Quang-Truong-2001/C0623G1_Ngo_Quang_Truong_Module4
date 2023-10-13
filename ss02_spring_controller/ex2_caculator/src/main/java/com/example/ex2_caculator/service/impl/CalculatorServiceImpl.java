package com.example.ex2_caculator.service.impl;

import com.example.ex2_caculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public double calculator(double numberOne, double numberTwo, String operator) {
        double result = 0;
        switch (operator) {
            case "Addition":
                result = numberOne + numberTwo;
                break;
            case "Subtraction":
                result = numberOne - numberTwo;
                break;
            case "Multiplication":
                result = numberOne * numberTwo;
                break;
            case "Division":
                result = numberOne / numberTwo;
                break;
        }
        return result;
    }
}
