package com.github.soulmachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.soulmachine.operations.OperationInterface;

import java.util.List;
import java.util.Map;

@Component
public class CalculatorV2 {
    private final Map<Operation, OperationInterface> operations;

    @Autowired
    public CalculatorV2(Map<Operation, OperationInterface> operations) {
        this.operations = operations;
    }

    // Perform a single operation
    public Number calculate(Operation operation, Number num1, Number num2) {
        OperationInterface operationInstance = operations.get(operation);
        if (operation == null) {
            throw new UnsupportedOperationException("Operation not supported.");
        }
        return operationInstance.apply(num1, num2);
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
