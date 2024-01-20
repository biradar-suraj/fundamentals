package org.drogo.basics.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSum {

    public static void main(String[] args) {

    }

    public int[] twoSumUsingHashMap(int[] numbers, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];

            if (hashMap.containsKey(complement)) {
                return new int[]{hashMap.get(complement), i};
            }
            hashMap.put(numbers[i], i);
        }
        return null;

    }

    public int[] usingStreams(int[] numbers, int target) {
        Map<Integer, Integer> hashMap = IntStream.range(0, numbers.length)
                .boxed()
                .collect(Collectors.toMap(i -> numbers[i], Function.identity()));

        OptionalInt result = IntStream.range(0, numbers.length)
                .filter(i -> hashMap.containsKey(target - numbers[i]) && hashMap.get(target - numbers[i]) != i)
                .findFirst();

        return result.isPresent() ? new int[]{result.getAsInt(), hashMap.get(target - numbers[result.getAsInt()])} : null;

    }

    public int[] twoSumBruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }


}

