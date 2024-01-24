package org.drogo.basics.problems.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Elixir {

    public static void main(String[] args) {

        int[] nums = {12, 32, 45, 78, 124};
        System.out.println(getNumbersWithOne(nums));

        String str = "Hello World";
        System.out.println(characterOccurrence(str));

    }

    static List<Integer> getNumbersWithOne(int[] nums) {

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (String.valueOf(num).startsWith("1")) {
                list.add(num);
            }

        }

        return list;

    }

    public static Map.Entry<Character, Integer> characterOccurrence(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);

    }
}
