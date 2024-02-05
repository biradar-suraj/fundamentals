package org.drogo.basics.oop.polymorphism;

public class OverloadingExample {

    void stringMethod(String input) {
        System.out.println("Input is String: " + input);
    }

    void stringMethod(StringBuilder input) {
        System.out.println("Input is StringBuilder: " + input);
    }

    void stringMethod(StringBuffer input) {
        System.out.println("Input is StringBuffer: " + input);
    }

    int addTwoNumbers(int a, int b) {
        System.out.println("Accepting int");
        return a + b;
    }

    int addTwoNumbers(Integer a, Integer b) {
        System.out.println("Accepting Integer");
        return a + b;
    }
}
