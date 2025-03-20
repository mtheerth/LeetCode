import java.util.HashMap;
import java.util.Map;

// Enum for Operation Types
enum OperationType {
    ADD, SUB, MUL, DIV
}

// Strategy Interface
interface Operation {
    double execute(double a, double b);
}

// Concrete Strategies
class Addition implements Operation {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}

class Subtraction implements Operation {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}

class Multiplication implements Operation {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}

class Division implements Operation {
    @Override
    public double execute(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}

// Factory Pattern to Create Operations
class OperationFactory {
    public static Operation getOperation(OperationType type) {
        return switch (type) {
            case ADD -> new Addition();
            case SUB -> new Subtraction();
            case MUL -> new Multiplication();
            case DIV -> new Division();
        };
    }
}

// Facade Pattern for Simplified Calculator Usage
class CalculatorFacade {
    public double calculate(OperationType operationType, double a, double b) {
        Operation operation = OperationFactory.getOperation(operationType);
        return operation.execute(a, b);
    }
}

// Usage
public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorFacade calculator = new CalculatorFacade();
        System.out.println("Addition: " + calculator.calculate(OperationType.ADD, 10, 5));
        System.out.println("Subtraction: " + calculator.calculate(OperationType.SUB, 10, 5));
        System.out.println("Multiplication: " + calculator.calculate(OperationType.MUL, 10, 5));
        System.out.println("Division: " + calculator.calculate(OperationType.DIV, 10, 5));
    }
}

