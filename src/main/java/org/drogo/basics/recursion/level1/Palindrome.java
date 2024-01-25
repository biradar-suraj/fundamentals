package org.drogo.basics.recursion.level1;

public class Palindrome {

    public static void main(String[] args) {
        int num=12343216;
        System.out.println(checkPalindrome(num));

    }

    static boolean checkPalindrome(int num){
        return num == reverse(num);
    }

    public static int reverse(int num) {
        int digits = Integer.toString(num).length();
        return helper(num, digits);

    }

    private static int helper(int num, int digits) {
        if (num % 10 == num) return num;
        int rem = num % 10;
        return (int) (rem * Math.pow(10, digits - 1) + helper(num / 10, digits - 1));


    }
}
