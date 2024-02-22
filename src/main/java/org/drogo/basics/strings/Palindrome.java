package org.drogo.basics.strings;

public class Palindrome {
    public static void main(String[] args) {
        String str = "Malayalam";
        System.out.println(isPalindrome(str));
        System.out.println(checkPalindrome(str));

    }

    static boolean isPalindrome(String string) {
        if (string == null || string.isEmpty()) {
            return true;
        }
        string = string.toLowerCase();
        for (int i = 0; i <= string.length() / 2; i++) {
            char start = string.charAt(i);
            char end = string.charAt(string.length() - 1 - i);

            if (start != end) return false;
        }

        return true;
    }

    public static boolean checkPalindrome(String input) {
        if (input.isEmpty() || input == null) return true;
        String lowercaseStr = input.toLowerCase();
        int start = 0;
        int end = lowercaseStr.length() - 1;

        while (start < end) {
            if (lowercaseStr.charAt(start) != lowercaseStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }
}
