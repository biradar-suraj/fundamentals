package org.drogo.basics.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    static void getAllPermutations(String input, String output) {
        if (input.isEmpty()) {
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);
        for (int i = 0; i <= output.length(); i++) {
            String first = output.substring(0, i);
            String second = output.substring(i);
            getAllPermutations(input.substring(1), first + ch + second);

        }

    }

    static List<String> getAllPermutationList(String input, String output) {
        List<String> stringList = new ArrayList<>();
        if (input.isEmpty()) {
            stringList.add(output);
            return stringList;
        }
        char ch = input.charAt(0);
        for (int i = 0; i <= output.length(); i++) {
            String first = output.substring(0, i);
            String second = output.substring(i);
            stringList.addAll(getAllPermutationList(input.substring(1), first + ch + second));

        }

        return stringList;

    }

    static int getAllPermutationsCount(String input, String output) {
        int count = 0;
        if (input.isEmpty()) {
            return 1;
        }
        char ch = input.charAt(0);
        for (int i = 0; i <= output.length(); i++) {
            String first = output.substring(0, i);
            String second = output.substring(i);
            count = count + getAllPermutationsCount(input.substring(1), first + ch + second);

        }
        return count;

    }

    public static void main(String[] args) {
        getAllPermutations("abc", "");
        System.out.println(getAllPermutationList("abc", ""));
        System.out.println(getAllPermutationsCount("abcd", ""));
    }
}
