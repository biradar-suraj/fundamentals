package org.drogo.basics.streams.studentengage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

//        Student tim = new Student(
//                "AU", 2019, 30, "M",
//                true, jmc, pymc
//        );
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);
//
//        Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
//                .limit(10)
//                .forEach(System.out::println);

//        generate 1000 random students
        Student[] students = new Student[1000];
        Arrays.setAll(students, i -> Student.getRandomStudent(jmc, pymc));

        var maleStudents = Arrays.stream(students)
                .filter(s -> s.getGender().equals("M"));
        System.out.println("Male students: " + maleStudents.count());

//        query all the genders
        for (String gender : List.of("M", "F", "U")) {
            var myStudents = Arrays.stream(students)
                    .filter(s -> s.getGender().equals(gender));
            System.out.println("Number of " + gender + " students: " + myStudents.count());
        }

//        group students by age ranges
        List<Predicate<Student>> list = List.of(
                (s) -> s.getAge() < 30,
                (Student s) -> s.getAge() >= 30 && s.getAge() < 60
        );

        long total = 0;
        for (int i = 0; i < list.size(); i++) {
            var myStudents = Arrays.stream(students)
                    .filter(list.get(i));
            long count = myStudents.count();
            total += count;
            System.out.printf("Number of students (%s)= %d%n",
                    i == 0 ? "< 30" : "Between 30 and 60", count);
        }
        System.out.println("Number of students 60 and above= " + (students.length - total));

        List<Student> under30 = Arrays.stream(students)
                .filter(student -> student.getAge() < 30)
                .toList();

        List<Student> between30And60 = Arrays.stream(students)
                .filter(student -> student.getAge() >= 30 && student.getAge() <= 60)
                .toList();

        List<Student> over60 = Arrays.stream(students)
                .filter(student -> student.getAge() > 60)
                .toList();

//        summary statistics
        var ageStream = Arrays.stream(students)
                .mapToInt(Student::getAgeEnrolled);
        System.out.println("Stats for Enrollment Age: " + ageStream.summaryStatistics());

        var currentAgeStream = Arrays.stream(students)
                .mapToInt(Student::getAge);
        System.out.println("Stats for Current Age: " + currentAgeStream.summaryStatistics());

        Arrays.stream(students)
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        boolean longTerm = Arrays.stream(students)
                .anyMatch(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12));
        System.out.println("Long term students? " + longTerm);

        long longTermCount = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .count();
        System.out.println("Long term students count " + longTermCount);

        Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toList()
                .forEach(System.out::println); //stream ends at toList() forEach is performed on toList() and not on stream, not a terminal operation

        List<Student> longTimeLearners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .toList();  // introduced in java 16
        longTimeLearners.forEach(System.out::println);

        var longTimeArray = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
//                .toArray();
                .toArray(Student[]::new);

        var learners = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .collect(Collectors.toList());

        Collections.shuffle(learners);


    }
}
