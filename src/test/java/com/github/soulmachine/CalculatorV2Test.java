package com.github.soulmachine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.github.soulmachine.operations.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorV2Test {

    @Mock
    private AddOperation addOperation;

    @Mock
    private SubtractOperation substractOperation;

    @Mock
    private MultiplyOperation multiplyOperation;

    @Mock
    private DivideOperation divideOperation;

    @Mock
    private ModOperation modOperation;

    private Map<Operation, OperationInterface> operations;

    @InjectMocks
    private CalculatorV2 calculator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize operation strategies map
        operations = new HashMap<>();
        operations.put(Operation.ADD, addOperation);
        operations.put(Operation.SUBSTRACT, substractOperation);
        operations.put(Operation.MULTIPLY, multiplyOperation);
        operations.put(Operation.DIVIDE, divideOperation);
        operations.put(Operation.MOD, modOperation);

        // Initialize calculator with an initial value and the mocked operation strategies
        calculator = new CalculatorV2(operations);
    }

    @Test
    public void testAdd() {
        // Arrange
        when(addOperation.apply(5, 3)).thenReturn(8);

        // Act
        Number result = calculator.calculate(Operation.ADD, 5, 3);

        // Assert
        assertEquals(8, result.doubleValue(), "Add operation failed");
    }

    @Test
    public void testSubstract() {
        // Arrange
        when(substractOperation.apply(5, 3)).thenReturn(2.0);

        // Act
        Number result = calculator.calculate(Operation.SUBSTRACT, 5, 3);

        // Assert
        assertEquals(2.0, result.doubleValue(), "Substract operation failed");
    }

    @Test
    public void testMultiply() {
        // Arrange
        when(multiplyOperation.apply(5, 3)).thenReturn(15);

        // Act
        Number result = calculator.calculate(Operation.MULTIPLY, 5, 3);

        // Assert
        assertEquals(15.0, result.doubleValue(), "Multiply operation failed");
    }

    @Test
    public void testDivide() {
        // Arrange
        when(divideOperation.apply(5, 2)).thenReturn(2.5);

        // Act
        Number result = calculator.calculate(Operation.DIVIDE, 5, 2);

        // Assert
        assertEquals(2.5, result.doubleValue(), "Divide operation failed");
    }

    @Test
    public void testMod() {
        // Arrange
        when(modOperation.apply(5, 3)).thenReturn(2.0);

        // Act
        Number result = calculator.calculate(Operation.MOD, 5, 3);

        // Assert
        assertEquals(2.0, result.doubleValue(), "Mod operation failed");
    }

    @Test
    public void testChainedOperations() {
        // Arrange
        when(addOperation.apply(5.0, 3.0)).thenReturn(8.0);
        when(multiplyOperation.apply(8.0, 2.0)).thenReturn(16.0);

        List<ChainedOperation> operations = Arrays.asList(new ChainedOperation(Operation.ADD, 3.0), new ChainedOperation(Operation.MULTIPLY, 2.0));

        // Act
        Number result = calculator.chainOperations(5.0, operations);

        // Assert
        assertEquals(16.0, result.doubleValue(), "Chaining operations failed");
    }
}
