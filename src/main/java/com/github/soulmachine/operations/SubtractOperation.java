package com.github.soulmachine.operations;

import org.springframework.stereotype.Component;

@Component
public class SubtractOperation implements OperationInterface {
    @Override
    public Number apply(Number left, Number right) {
        return left.doubleValue() - right.doubleValue();
    }
}
