package org.drogo.basics.problems.strings;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PermutationSubstringFinder {
    public static void main(String[] args) {
        String a = "arta";
        String b = "eartha";
        System.out.println(every(a, b));

    }

    static boolean every(String substring, String string) {
        Map<Character, List<Character>> collect = string.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(ch -> ch));

        Map<Character, List<Character>> collect1 = substring.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(ch -> ch));

        for (Map.Entry<Character, List<Character>> entry : collect1.entrySet()) {
            if (!collect.containsKey(entry.getKey())) {
                return false;
            }
            List<Character> value = collect.get(entry.getKey());
            if (value.size() != entry.getValue().size()) {
                return false;
            }
        }
        return true;
    }
}
