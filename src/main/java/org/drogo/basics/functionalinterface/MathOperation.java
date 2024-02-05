package org.drogo.basics.functionalinterface;

@FunctionalInterface
public interface MathOperation {
    int execute(int a, int b);

    // Default method to add two numbers
    default int add(int a, int b) {
        return execute(a, b);
    }

    // Default method to subtract two numbers
    default int subtract(int a, int b) {
        return execute(a, b);
    }

    // Default method to multiply two numbers
    default int multiply(int a, int b) {
        return execute(a, b);
    }

    // Default method to divide two numbers
    default int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return execute(a, b);
    }

    // Static methods
    static int square(int number) {
        return number * number;
    }

    static int cube(int number) {
        return number * number * number;
    }
}
