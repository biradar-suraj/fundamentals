package org.drogo.basics.oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        Shape shape= new Shape();
        Circle circle=new Circle();
        Square square= new Square();

        Shape squareShape = new Square();

        squareShape.area();
    }
}
