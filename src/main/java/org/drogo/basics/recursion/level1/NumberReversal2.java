package org.drogo.basics.recursion.level1;

public class NumberReversal2 {
    static int reverseRecursion(int n, int reversed) {
        if (n == 0) {
            return reversed;
        } else {
            int remainder = n % 10;
            reversed = reversed * 10 + remainder;
            return reverseRecursion(n / 10, reversed);
        }
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Reversed Number: " + reverseRecursion(num,0));
    }
}

