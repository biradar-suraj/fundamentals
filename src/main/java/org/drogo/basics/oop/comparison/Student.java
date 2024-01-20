package org.drogo.basics.oop.comparison;

public class Student implements Comparable<Student> {

    public Student(String name, int rollNo, float marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    String name;
    int rollNo;
    float marks;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rollNo=" + rollNo +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return (int) (this.marks-o.marks);
    }
}
