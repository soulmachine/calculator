# Flexible Calculator

A versatile and extensible calculator implementation that supports basic operations and chaining, designed with IoC compatibility in mind.

## How to Run

`mvn clean test`

## Features

1. Basic operations (ADD, SUBTRACT, MULTIPLY, DIVIDE) defined in an `Operation` enum.
2. Single operation `calculation` method.
3. Operations can be chained sequentially.
4. Extensible design allowing new operations without modifying the `Calculator` class.
5. IoC compatibility for easy testing and implementation swapping.
6. Division by zero is handled gracefully by throwing an `ArithmeticException`.

## Architecture

![Architecture](./images/architecture.svg)


## How to Use


### Basic Calculation


```java
Calculator calc = new Calculator();
double result = calc.calculate(Operation.ADD, 2, 3); // Returns 5
```

### Chaining Operations

```java
Calculator calc = new Calculator();
List<ChainedOperation> operations = Arrays.asList(
new ChainedOperation(Operation.ADD, 3),
new ChainedOperation(Operation.MULTIPLY, 2)
);
double result = calc.chainOperations(5, operations); // Returns 16
```

## IoC-Compatible

`CalculatorV2` is a IoC-compatible version of `CalculatorV1`:

* **Dependency Injection**: Operations can be injected, allowing for easy swapping of implementations.
* **Loose Coupling**: The calculator works with any operation defined in the `Operation` enum without changing its core logic.
* **Testability**: Mocking or injecting different operations during unit testing is straightforward.
