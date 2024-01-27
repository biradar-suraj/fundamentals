package org.drogo.basics.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class ExploringStreams {

    public static void main(String[] args) {

        int[] nums = {1, 4, 6, 7, 8, 9, 13, 19, 17};


        //find the largest number in an array
        int largestNumber = Arrays.stream(nums).max().getAsInt();
        System.out.println(largestNumber);

        //find the second largest in an array
        OptionalInt secondLargest = Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .mapToInt(Integer::intValue)
                .findFirst();

        secondLargest.ifPresent(System.out::println);

        //calculate average
        double average = Arrays.stream(nums)
                .average().getAsDouble();

        List<String> words = Arrays.asList("Hello", "World");
        List<String> upperCaseWords = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(upperCaseWords);


    }
}
