package com.github.soulmachine;

/// Wraps an operation and its right operand.
public class ChainedOperation {
    private final Operation operation;
    private final Number rightOperand;

    public ChainedOperation(Operation operation, Number rightOperand) {
        this.operation = operation;
        this.rightOperand = rightOperand;
    }

    public Operation getOperation() {
        return operation;
    }

    public Number getRightOperand() {
        return rightOperand;
    }
}