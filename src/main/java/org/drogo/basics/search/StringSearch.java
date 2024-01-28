package org.drogo.basics.search;

public class StringSearch {

    public static void main(String[] args) {
        String str = "Suraj";
        char target = 'u';
        System.out.println(search(str, target));

    }

    static boolean search(String str, char target) {
        if (str.isEmpty()) return false;

        for (char ch : str.toCharArray()) {
            if (target == ch) return true;

        }
        return false;
    }
}
