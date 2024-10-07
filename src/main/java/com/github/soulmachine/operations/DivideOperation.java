package com.github.soulmachine.operations;

import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements OperationInterface {
    @Override
    public Number apply(Number left, Number right) {
        if (right.doubleValue() == 0.0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return left.doubleValue() / right.doubleValue();
    }
}