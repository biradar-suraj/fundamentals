package org.drogo.basics.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ShuffleWithRandom {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }

        Random random = new Random(12345);
        System.out.println("Original list: " + numbers);

        Collections.shuffle(numbers);
        System.out.println("Shuffled list: " + numbers);

        Collections.shuffle(numbers, random);
        System.out.println("Shuffled with random: " + numbers);
    }
}
