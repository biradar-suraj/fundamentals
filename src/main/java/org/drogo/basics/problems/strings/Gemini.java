package org.drogo.basics.problems.strings;

public class Gemini {
    public static void main(String[] args) {
        String input = "aaabbcaa"; //a3b2c1a2
        System.out.println(findOccurrences(input));


    }

    static String findOccurrences(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) != str.charAt(i - 1)) {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1;
            } else {
                count++;
            }
        }
        return sb.toString();
    }


}
