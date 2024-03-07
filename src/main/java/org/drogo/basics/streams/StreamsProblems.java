package org.drogo.basics.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamsProblems {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        // sum and product of all elements of the given array
        int reducedSum = Arrays
                .stream(arr)
                .reduce(0, (left, right) -> left + right);

        int reducedProduct = Arrays
                .stream(arr)
                .reduce(1, (left, right) -> left * right);

        System.out.println(Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst());

        /*  Using Stream API,
            need to extract the names of employees which starts with characters "Su",
            (it should be case-insensitive)
        */
        List<String> namesList = Arrays.asList(
                "Suraj", "surendra", "Sumeet", "Ramki", "Krishna"
        );

        List<String> namesStartingWithSu = namesList.stream()
                .filter(n -> n.toLowerCase().startsWith("su"))
                .toList();

        System.out.println(namesStartingWithSu);

        /* Given an Array List .
           Find all the even number,
           do their square and perform addition: */

        List<Integer> nums = Arrays.asList(2, 4, 7, 3, 9, 2);
        Integer evenSquaredSum = nums.stream()
                .filter(num -> num % 10 == 0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);
    }
}
