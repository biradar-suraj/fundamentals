package org.drogo.basics.streams.studentengage;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* Collect code in a single place */
public class MainCollect {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .toList();

        Set<Student> australianStudents = students.stream()
                .filter(s -> s.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());
        System.out.println("Number of Australian students: " + australianStudents.size());

        Set<Student> under30 = students.stream()
                .filter(s -> s.getAgeEnrolled() < 30)
                .collect(Collectors.toSet());
        System.out.println("Number of students under 30: " + under30.size());

        Set<Student> youngAussies1 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
        youngAussies1.addAll(australianStudents);
        youngAussies1.retainAll(under30);
        youngAussies1.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();


        Set<Student> youngAussies2 = students.stream()
                .filter(s -> s.getAgeEnrolled() < 30)
                .filter(s -> s.getCountryCode().equals("AU"))
//                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)), TreeSet::add, TreeSet::addAll); // supplier,, accumulator and combiner

        youngAussies2.forEach(s -> System.out.print(s.getStudentId() + " "));
        System.out.println();

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (r, v) -> r + " " + v);
        System.out.println("countryList: " + countryList);

    }
}
