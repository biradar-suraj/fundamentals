package org.drogo.basics.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Perennial {
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

    }
}
