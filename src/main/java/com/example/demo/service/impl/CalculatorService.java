package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("b cannot be 0");
        }

        return a / b;
    }

    public String classifyNumber(int number) {
        if (number > 0) {
            return "POSITIVE";
        }

        if (number < 0) {
            return "NEGATIVE";
        }

        return "ZERO";
    }
}
