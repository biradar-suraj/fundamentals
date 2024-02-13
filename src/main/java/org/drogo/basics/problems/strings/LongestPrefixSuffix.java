package org.drogo.basics.problems.strings;

public class LongestPrefixSuffix {

    public static void main(String[] args) {
        String a = "xyxyxy";
        String b = "aabcdaabc";
        String c = "codility";
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));

    }

    public static int solution(String s) {
        if (s == null || s.isEmpty()) {
            return 0;

        }
        int result = 0;
        int n = s.length();
        for (int l = 1; l <= n - 1; l++) {
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();

            for (int i = 0; i < l; i++) {
                prefix.append(s.charAt(i));
            }

            for (int i = n - l; i < n; i++) {
                suffix.append(s.charAt(i));
            }

            if (suffix.toString().contentEquals(prefix)) {
                result = l;
            }
        }
        return result;
    }
}
