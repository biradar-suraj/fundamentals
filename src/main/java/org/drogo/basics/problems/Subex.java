package org.drogo.basics.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Subex {

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 6, 7, 8, 9, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 9};
        System.out.println(Arrays.toString(numberOfOccurrences(nums)));

    }

    static int[] numberOfOccurrences(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey() - a.getKey();
            } else {
                return b.getValue() - a.getValue();
            }
        });

        queue.addAll(map.entrySet());

        int[] result = new int[nums.length];
        int index = 0;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                result[index++] = entry.getKey();
            }
        }

        return result;
    }


}
