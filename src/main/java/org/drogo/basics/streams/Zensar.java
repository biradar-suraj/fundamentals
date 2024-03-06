package org.drogo.basics.streams;

import java.util.Arrays;
import java.util.List;

/*  Using Stream API,
    need to extract the names of employees which starts with characters "Su",
    (it should be case insensitive)
*/
public class Zensar {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList(
                "Suraj", "surendra", "Sumeet", "Ramki", "Krishna"
        );

        List<String> namesStartingWithSu = namesList.stream()
                .filter(n -> n.toLowerCase().startsWith("su"))
                .toList();

        System.out.println(namesStartingWithSu);


    }
}
