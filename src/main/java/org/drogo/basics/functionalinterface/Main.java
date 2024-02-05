package org.drogo.basics.functionalinterface;

public class Main {
    public static void main(String[] args) {
        MathOperation mathOperation = new MathOperation() {
            @Override
            public int execute(int a, int b) {
                return a + b;
            }
        };

        int sum = mathOperation.add(5, 3);
        int difference = mathOperation.subtract(5, 3);

        int square = MathOperation.square(5);
        int cube = MathOperation.cube(5);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Square: " + square);
        System.out.println("Cube: " + cube);

        //Using Lambdas
        MathOperation mathOpAdd = (a, b) -> a + b;
        int add = mathOpAdd.add(5, 3);

        MathOperation mathOpSubtract = (a, b) -> a - b;
        int subtract = mathOpSubtract.subtract(5, 3);
        System.out.println("Added using lambda: " + add);
        System.out.println("Subtracted using lambda: " + subtract);

    }
}
