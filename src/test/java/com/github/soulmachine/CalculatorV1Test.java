package com.github.soulmachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class CalculatorV1Test {

    private CalculatorV1 calculator = new CalculatorV1();

    @Test
    public void testAddition() {
        Number result = calculator.calculate(Operation.ADD, 3, 5);
        assertEquals(8.0, result.doubleValue());
    }

    @Test
    public void testSubstractition() {
        Number result = calculator.calculate(Operation.SUBSTRACT, 5, 2);
        assertEquals(3.0, result.doubleValue());
    }

    @Test
    public void testMultiply() {
        Number result = calculator.calculate(Operation.MULTIPLY, 5, 2);
        assertEquals(10.0, result.doubleValue());
    }

    @Test
    public void testDivide() {
        Number result = calculator.calculate(Operation.DIVIDE, 6, 2);
        assertEquals(3.0, result.doubleValue());
    }

    @Test
    public void testMod() {
        Number result = calculator.calculate(Operation.MOD, 7, 3);
        assertEquals(1.0, result.doubleValue());
    }

    @Test
    public void testChainingOperations() {
        List<ChainedOperation> operations = Arrays.asList(new ChainedOperation(Operation.ADD, 3), new ChainedOperation(Operation.MULTIPLY, 2));
        Number result = calculator.chainOperations(5, operations);
        assertEquals(16.0, result.doubleValue());
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(Operation.DIVIDE, 3.0, 0.0);
        });
    }
}
