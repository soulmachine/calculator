package com.github.soulmachine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.soulmachine.operations.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CalculatorConfig {

    @Bean
    public Map<Operation, OperationInterface> operationStrategies(AddOperation addOperation,
                                                                 SubtractOperation substractOperation,
                                                                 MultiplyOperation multiplyOperation,
                                                                 DivideOperation divideOperation,
                                                                 ModOperation modOperation) {
        Map<Operation, OperationInterface> operations = new HashMap<>();
        operations.put(Operation.ADD, addOperation);
        operations.put(Operation.SUBSTRACT, substractOperation);
        operations.put(Operation.MULTIPLY, multiplyOperation);
        operations.put(Operation.DIVIDE, divideOperation);
        operations.put(Operation.MOD, modOperation);
        // Add more operations here
        return operations;
    }
}
