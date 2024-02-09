package org.drogo.basics.problems;

public class PalindromeChecker {
    public static void main(String[] args) {
        System.out.println(solve(6, "ababaa")); // Output: YES
        System.out.println(solve(5, "abcaa")); // Output: NO
    }

    public static String solve(int n, String letters) {
        int[] charCounts = new int[26]; // Assuming ASCII characters
        for (char c : letters.toCharArray()) {
            charCounts[c - 'a']++;
        }

        int oddCount =  0;
        for (int count : charCounts) {
            if (count %  2 !=  0) {
                oddCount++;
            }
        }

        return oddCount <=  1 ? "YES" : "NO";
    }
}
