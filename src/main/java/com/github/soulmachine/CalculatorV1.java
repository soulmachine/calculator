package com.github.soulmachine;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import com.github.soulmachine.operations.OperationInterface;
import com.github.soulmachine.operations.*;

public class CalculatorV1 {

    private final Map<Operation, OperationInterface> operations = new HashMap<>();

    public CalculatorV1() {
        operations.put(Operation.ADD, new AddOperation());
        operations.put(Operation.SUBSTRACT, new SubtractOperation());
        operations.put(Operation.MULTIPLY, new MultiplyOperation());
        operations.put(Operation.DIVIDE, new DivideOperation());
        operations.put(Operation.MOD, new ModOperation());
        // Add more operations here
    }

    // Perform a single operation
    public Number calculate(Operation operation, Number num1, Number num2) {
        return operations.get(operation).apply(num1, num2);
    }

    // Start with an initial value and apply multiple operations in sequence.
    public Number chainOperations(double initialValue, List<ChainedOperation> operations) {
        Number result = initialValue;
        for (ChainedOperation op : operations) {
            result = this.operations.get(op.getOperation()).apply(result, op.getRightOperand());
        }
        return result;
    }
}
