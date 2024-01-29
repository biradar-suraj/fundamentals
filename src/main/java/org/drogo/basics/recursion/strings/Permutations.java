package org.drogo.basics.recursion.strings;

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

    public static void main(String[] args) {
        getAllPermutations("abc", "");
    }
}
