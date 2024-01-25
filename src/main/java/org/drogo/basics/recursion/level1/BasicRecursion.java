package org.drogo.basics.recursion.level1;

public class BasicRecursion {
    public static void main(String[] args) {
        int n = 5;
        printBoth(n);

    }

    static void print(int n) {
        if (n == 0) {
            return;
        }
        print(n - 1);
        System.out.println(n);
    }

    static void printReverse(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printReverse(n - 1);

    }

    static void printBoth(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printBoth(n - 1);
        System.out.println(n);
    }
}
