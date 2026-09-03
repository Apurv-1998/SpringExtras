package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.instrument.Instrumentation;

import org.junit.jupiter.api.Test;

import com.example.demo.service.impl.CalculatorService;

public class CalculatorServiceTest {

    private final CalculatorService service = new CalculatorService();

    @Test
    void shouldAddTwoNumbers() {

        int result = service.add(2, 3);

        assertEquals(5, result);
    }

    @Test
    void shouldDivideTwoNumbers(){
        int result = service.divide(20,5);
        assertEquals(4, result);
    }

}
