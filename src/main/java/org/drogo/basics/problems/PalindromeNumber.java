package org.drogo.basics.problems;

/*  9. Palindrome Number
    https://leetcode.com/problems/palindrome-number/    */
public class PalindromeNumber {

    static boolean isPalindrome(int x) {
        if (x < 0) return false;

        int reverse = 0;
        int temp = x;

        while (temp > 0) {
            int digit = temp % 10;
            reverse = reverse * 10 + digit;
            temp = temp / 10;
        }
        return reverse == x;
    }

    public static void main(String[] args) {
        int x = 121;
        int y = -121;
        int z = 10;

        System.out.println(isPalindrome(x));
        System.out.println(isPalindrome(y));
        System.out.println(isPalindrome(z));
    }
}
