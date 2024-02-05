package org.drogo.basics.oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();
        Square square = new Square();

        Shape squareShape = new Square();
        squareShape.area();

        OverloadingExample overloading = new OverloadingExample();
        overloading.stringMethod("Suraj");
        overloading.stringMethod(new StringBuffer("Suraj"));
        overloading.stringMethod(new StringBuilder("Suraj"));

        int sum = overloading.addTwoNumbers(5, 3);
        Integer num1 = 8;
        Integer num2 = 2;
        int added = overloading.addTwoNumbers(num1, num2);

        int primitiveInt= 9;
        Integer wrapperInt = primitiveInt; //autoboxing

        Integer wrapperInt1= 4;
        int primitiveInt1= wrapperInt1; //unboxing

    }
}
