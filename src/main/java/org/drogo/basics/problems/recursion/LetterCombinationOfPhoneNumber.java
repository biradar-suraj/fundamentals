package org.drogo.basics.problems.recursion;

import java.util.ArrayList;
import java.util.List;

/*  17. Letter Combinations of a Phone Number
 *   https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class LetterCombinationOfPhoneNumber {

    static void getAllCombination(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }

        int digit = Character.getNumericValue(input.charAt(0));

        if (digit == 1) {
            getAllCombination(input.substring(1), output);
            return;
        }
        if (digit == 7) {
            for (char ch : new char[]{'p', 'q', 'r', 's'}) {
                getAllCombination(input.substring(1), output + ch);
            }
            return;
        }
        if (digit == 9) {
            for (char ch : new char[]{'w', 'x', 'y', 'z'}) {
                getAllCombination(input.substring(1), output + ch);
            }
            return;
        }
        for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
            char ch = (char) ('a' + i);
            getAllCombination(input.substring(1), output + ch);
        }

    }

    static List<String> getAllCombinationList(String input, String output) {
        List<String> ansList = new ArrayList<>();
        if (input.isEmpty()) {
            ansList.add(output);
            return ansList;
        }

        int digit = input.charAt(0) - '0';
        //int digit = Character.getNumericValue(input.charAt(0));

        if (digit == 1) {
            return getAllCombinationList(input.substring(1), output);

        }
        if (digit == 7) {
            for (char ch : new char[]{'p', 'q', 'r', 's'}) {
                ansList.addAll(getAllCombinationList(input.substring(1), output + ch));
            }
            return ansList;
        }
        if (digit == 9) {
            for (char ch : new char[]{'w', 'x', 'y', 'z'}) {
                ansList.addAll(getAllCombinationList(input.substring(1), output + ch));
            }
            return ansList;
        }
        for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
            char ch = (char) ('a' + i);
            ansList.addAll(getAllCombinationList(input.substring(1), output + ch));
        }

        return ansList;

    }

    public static void main(String[] args) {
        getAllCombination("72", "");
        System.out.println(getAllCombinationList("", ""));
    }
}
