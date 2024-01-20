package org.drogo.basics.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AddictedToStreams {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 910);

        System.out.println(numbers.stream()
                .filter(e -> e % 2 == 0)
                .mapToInt(AddictedToStreams::compute)
                .sum());


        numbers.stream()
                .filter(e-> e%2==0)
                .map(e -> e*2)
                .collect(Collectors.toList());
    }

    public static int compute(int number){
        //time intensive
        return number*2;
    }
}
