package org.drogo.basics.recursion.level1;

public class ZeroCount {
    public static void main(String[] args) {
        int num= 50001020;
        System.out.println(findZeroes(num));

    }

    static int findZeroes(int num) {
        return helper(num, 0);
    }

    private static int helper(int num, int c) {
        if (num == 0) {
            return c;
        }
        int rem = num % 10;
        if (rem == 0) {
            return helper(num / 10, c + 1);
        }
        return helper(num / 10, c);
    }
}
