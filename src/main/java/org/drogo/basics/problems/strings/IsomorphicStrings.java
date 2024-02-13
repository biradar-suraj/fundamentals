package org.drogo.basics.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public static boolean isomorphicStrings(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }

        Map<Character, Character> characterMap = new HashMap<>();

        for (int i = 0; i < first.length(); i++) {
            char original = first.charAt(i);
            char replacement = second.charAt(i);

            if (!characterMap.containsKey(original)) {
                if (!characterMap.containsValue(replacement)) {
                    characterMap.put(original, replacement);

                } else {
                    return false;
                }

            } else {
                char mappedChar = characterMap.get(original);
                if (mappedChar != replacement) {
                    return false;
                }

            }

        }
        return true;
    }

    public static void main(String[] args) {
        String first = "paper";
        String second = "title";
        System.out.println(isomorphicStrings(first, second));
    }
}
