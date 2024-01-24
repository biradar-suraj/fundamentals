package org.drogo.basics.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    String name;
    String subject;
    Double marks;
    String grade;

    public Student(String name, String subject, Double marks) {
        this.name = name;
        this.subject = subject;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                ", marks=" + marks +
                ", grade='" + grade + '\'' +
                '}';
    }
}

class Interview {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Ram", "maths", 85.5));
        studentList.add(new Student("Pranav", "maths", 90.5));
        studentList.add(new Student("Vibin", "maths", 92.0));
        studentList.add(new Student("Nikhil", "maths", 60.0));
        studentList.add(new Student("Sushil", "science", 60.0));

        studentList.stream()
                .filter(student -> student.getMarks() > 90)
                .forEach(student -> student.setGrade("AA"));

        System.out.println(studentList);

    }
}
