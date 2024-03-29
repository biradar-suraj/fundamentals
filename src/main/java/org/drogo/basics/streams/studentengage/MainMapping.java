package org.drogo.basics.streams.studentengage;

import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class MainMapping {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);

        var students = Stream
                .iterate(1, s -> s <= 5000, s -> s + 1)
                .map(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        var mappedStudents = students.stream()
                .collect(groupingBy(Student::getCountryCode));

        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));
        System.out.println("--------------------------------");

        int minAge = 25;
        var youngerSet = students.stream()
                .collect(
                        groupingBy(Student::getCountryCode,
                                filtering(s -> s.getAge() <= minAge, toList()))
                );
        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("Experienced students: " + experienced.get(true).size());

        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("Experienced students: " + expCount.get(true));

        var experiencedAndActive = students.stream()
                .collect(partitioningBy(
                        s -> s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0,
                        counting()));
        System.out.println("Experienced and active students: " + experiencedAndActive.get(true));

        var multilevel = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        groupingBy(Student::getGender)));

        multilevel.forEach(
                (key, value) -> {
                    System.out.println(key);
                    value.forEach((k, v) -> System.out.println("\t" + k + " " + v.size()));
                }
        );

        long studentBodyCount = 0;

        for (var list : experienced.values()) {
            studentBodyCount += list.size();
        }
        System.out.println("student body count: " + studentBodyCount);

        studentBodyCount = experienced.values()
                .stream()
                .mapToInt(l -> l.size())
                .sum();
        System.out.println("student body count: " + studentBodyCount);

        studentBodyCount = experienced.values()
                .stream()
                .map(l -> l.stream()
                        .filter(s -> s.getMonthsSinceActive() <= 3)
                        .count()
                )
                .mapToLong(l -> l)
                .sum();
        System.out.println("student body count: " + studentBodyCount);

        long count = experienced.values()
                .stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active students: " + count);

        count = multilevel.values()
                .stream()
                .flatMap(map -> map.values().stream()
                        .flatMap(l -> l.stream())
                )
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active students: " + count);

        count = multilevel.values()
                .stream()
                .flatMap(map -> map.values().stream())
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active students: " + count);

    }
}
