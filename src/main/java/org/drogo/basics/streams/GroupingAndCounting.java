package org.drogo.basics.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupingAndCounting {

    public static void main(String[] args) {
        String str = "Suraj Biradar";
        Map<Character, Long> collect = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));


        System.out.println(collect);

        List<String> namesList = new ArrayList<>(Arrays.asList("Adam", "Bill", "Jack", "Joe", "Ian"));
        Map<Integer, Long> result = namesList.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        System.out.println(result);

        List<String> list1 = new ArrayList<>(Arrays.asList("Foo", "Bar", "Bar", "Bar", "Foo"));
        Map<String, Long> collect1 = list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect1);

        List<String> distinctList = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctList);

        List<Student> students = Arrays.asList(new Student("Suraj", "maths", 45.0),
                new Student("Ramki", "science", 90.0),
                new Student("Sumeet", "english", 85.0),
                new Student("Gagan", "hindi", 60.0));

        Map<String, Long> collect2 = students.stream()
                .collect(Collectors.groupingBy(student -> String.valueOf(student.getMarks()), Collectors.counting()));

        System.out.println(collect2);

        Double marksSum = students.stream().mapToDouble(Student::getMarks).sum();
        System.out.println(marksSum);

    }

}
