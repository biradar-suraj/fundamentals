package org.drogo.basics.problems.strings;

public class StringContainSubstring {
    static boolean doesContain(String substring, String string) {
        int subLength = substring.length();
        int stringLength = string.length();

        if (subLength > stringLength) {
            return false;
        }
        for (int i = 0; i <= stringLength - subLength; i++) {
            int j;
            for (j = 0; j < subLength; j++) {
                if (string.charAt(i + j) != substring.charAt(j)) {
                    break;
                }
            }
            if (j == subLength) {
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String a = "art";
        String b = "earth";
        System.out.println(doesContain(a, b));

    }
}
