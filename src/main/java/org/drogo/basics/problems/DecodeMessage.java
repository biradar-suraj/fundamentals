package org.drogo.basics.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DecodeMessage {

    static String decodeMessage(String encodedMessage) {
        String[] words = encodedMessage.split("\\s+");
        Map<Integer, String> keyValueMap = new HashMap<>();

        for (String word : words) {
            int key = 0;
            StringBuilder value = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    key += Character.getNumericValue(ch);
                } else {
                    value.append(ch);

                }
            }
            keyValueMap.put(key, value.toString());
        }


        // sorting HashMap using entrySet
        /*ArrayList<Map.Entry<Integer, String>> entries = new ArrayList<>(keyValueMap.entrySet());
        Collections.sort(entries, Comparator.comparingInt(Map.Entry::getKey));*/

        // sorting HashMap using TreeSet
        TreeMap<Integer, String> treeMap = new TreeMap<>(keyValueMap);

        // imperative approach to iterate and append the values
        Set<Map.Entry<Integer, String>> entrySet = treeMap.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, String> entry : entrySet) {
            sb.append(entry.getValue()).append(" ");
        }

        //return sb.toString().trim();

        // functional approach
        return treeMap.values().stream().collect(Collectors.joining(" ")).trim();


    }

    public static void main(String[] args) {
        String encodedMessage = "t2e1st This i1s f1irs1t";
        System.out.println(decodeMessage(encodedMessage));
    }
}
