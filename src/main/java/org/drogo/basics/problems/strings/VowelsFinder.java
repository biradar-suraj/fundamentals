package org.drogo.basics.problems.strings;

import java.util.Arrays;
import java.util.List;

public class VowelsFinder {
    public static void main(String[] args) {

        String inputString = "Hello, Java 8 Vowels Example";

        String inputStringLowerCase = inputString.toLowerCase();

        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

        long count = inputStringLowerCase.chars()
                .mapToObj(c -> (char) c)
                .filter(vowels::contains)
                .count();
        System.out.println("Number of vowels: " + count);

    }
}
