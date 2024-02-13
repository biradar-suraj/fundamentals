package org.drogo.basics.problems.strings;

import java.util.Arrays;

/* 14. Longest Common Prefix
 *  https://leetcode.com/problems/longest-common-prefix/description/ */

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);

        String first = strs[0];
        String last = strs[strs.length - 1];

        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return result.toString();
            }
            result.append(first.charAt(i));

        }
        return result.toString();

    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String[] strs1 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix(strs1));
    }
}
