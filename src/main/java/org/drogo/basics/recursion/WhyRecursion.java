package org.drogo.basics.recursion;

public class WhyRecursion {

    public static void main(String[] args) {
        print1(1);
    }

    private static void print1(int n) {
        System.out.println(n);
        print2(2);
    }

    private static void print2(int n) {
        System.out.println(n);
        print3(3);
    }

    private static void print3(int n) {
        System.out.println(n);
        print4(4);
    }

    private static void print4(int n) {
        System.out.println(n);
        print5(5);

    }

    private static void print5(int n) {
        System.out.println(n);

    }
}
