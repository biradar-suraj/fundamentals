package org.drogo.basics.problems;

import java.util.*;

public class Subex {

    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 6, 7, 8, 9, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 9};
        numberOfOccurrences(nums);

    }

    static void numberOfOccurrences(int[] inputArray) {
        Map<Integer, Integer> elementCountMap = new HashMap<>();

        for (int i : inputArray) {
            if (elementCountMap.containsKey(i)) {
                elementCountMap.put(i, elementCountMap.get(i) + 1);
            } else {
                elementCountMap.put(i, 1);
            }
        }


        List<Map.Entry<Integer, Integer>> listOfEntries = new ArrayList<>(elementCountMap.entrySet());

        listOfEntries.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                return o2.getKey().compareTo(o1.getKey());
            } else {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Integer> outputList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : listOfEntries) {
            outputList.add(entry.getKey());
        }

        int[] outputArray = new int[outputList.size()];
        for (int i = 0; i < outputList.size(); i++) {
            outputArray[i] = outputList.get(i);
        }

        System.out.println(Arrays.toString(outputArray));
    }


}

