package org.drogo.basics.problems;

public class CountMatchingFirstLast {

    public static int countMatchingFirstLast(String s) {
        char first = s.charAt(0);
        int count = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (first == s.charAt(i)) {
                count++;
            } else {
                break;
            }

        }
        return count;

    }

    public static int recursiveApproach(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int length = s.length();
        
        char first = s.charAt(0);
        char last = s.charAt(length - 1);
        int count = 0;
        if (first == last) {
            count = 1 + recursiveApproach(s.substring(0, length - 1));
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countMatchingFirstLast("abbaa"));
        System.out.println(countMatchingFirstLast("aaaa"));
        System.out.println(countMatchingFirstLast("abab"));

        System.out.println(recursiveApproach("abbaa"));
        System.out.println(recursiveApproach("aaaa"));
        System.out.println(recursiveApproach("abab"));

    }
}
