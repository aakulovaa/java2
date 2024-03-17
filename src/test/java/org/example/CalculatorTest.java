package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void testCalculate() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("  2*5 -   36 / 6");
        assertEquals(4, result);
    }


    @Test
    public void testMethodThrowsException() {
        boolean exceptionThrown = false;
        Calculator calculator = new Calculator();
        try {
            calculator.calculate("1+ 2*5 -   3+6 / 0");
        } catch (RuntimeException e) {
            exceptionThrown = true;
        }
        assertTrue(exceptionThrown);
    }



}