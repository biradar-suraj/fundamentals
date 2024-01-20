package org.drogo.basics.patterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = Arrays.asList(4,5,6);
        List<Integer> list3 = Arrays.asList(7,8,9);

        List<Integer> newList= new ArrayList<>();
        newList.addAll(list1);
        newList.addAll(list2);
        newList.addAll(list3);

        List<Integer> collect = Stream.of(list1, list2, list3).flatMap(Collection::stream).toList();
        Stream<List<Integer>> listOfLists = Stream.of(list1, list2, list3);
        List<Integer> list = listOfLists.flatMap(Collection::stream).toList();


    }
}
