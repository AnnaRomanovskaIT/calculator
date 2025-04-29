package org.calculator;

public class Calculator {
    public static double calculate(Operation op, double a, double b) {
        return op.execute(a, b);  // Doesn't care if it's add or subtract, just executes the operation
    }
}
