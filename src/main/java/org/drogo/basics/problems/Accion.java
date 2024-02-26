package org.drogo.basics.problems;

import java.util.*;
import java.util.stream.Collectors;

/*  We have an array of 20 elements. Write a program to:
    [98, 100, 35, 75, 73, 81, 86, 75, 100, 75, 35, 75, 17, 98, 100, 35, 75, 73, 81, 86]
    a)	Print the count of duplicate values
    b)	Print the second highest value */
public class Accion {
    public static void main(String[] args) {
        int[] marksList = {98, 100, 35, 75, 73, 81, 86, 75, 100, 75, 35, 75, 17, 98, 100, 35, 75, 73, 81, 86};

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int marks : marksList) {
            countMap.put(marks, countMap.getOrDefault(marks, 0) + 1);
        }


        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Value " + entry.getKey() + " appears " + entry.getValue() + " times");
            }

        }

        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int marks : marksList) {
            if (marks > highest) {
                secondHighest = highest;
                highest = marks;
            } else if (marks > secondHighest && marks < highest) {
                secondHighest = marks;

            }
        }
        System.out.println("Second highest marks is: " + secondHighest);

        Map<Integer, Long> countMap1 = Arrays.stream(marksList)
                .boxed()
                .collect(Collectors.groupingBy(Integer::intValue, Collectors.counting()));

        countMap1.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> System.out.println("Value " + entry.getKey() + " appears " + entry.getValue() + " times"));

        Optional<Integer> secondHighest1 = Arrays.stream(marksList)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        secondHighest1.ifPresent(value -> System.out.println("Second highest marks is: " + value));

    }
}
