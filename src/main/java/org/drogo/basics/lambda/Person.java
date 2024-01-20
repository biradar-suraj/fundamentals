package org.drogo.basics.lambda;

import java.util.ArrayList;
import java.util.List;

public class Person {

    String name;
    int age;
    String emailAddress;
    Sex gender;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age, String emailAddress, Sex gender) {
        this.name = name;
        this.age = age;
        this.emailAddress = emailAddress;
        this.gender = gender;
    }

    public void printName(Person p){
        System.out.println(this.name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender=" + gender +
                '}';
    }

    public void printPerson(){
        System.out.println(this.toString());
    }

    public static List<Person> generateDefaultList(){
        ArrayList<Person> people = new ArrayList<>();

        people.add(
                new Person("Suraj",30,"suraj.biradar@email.com",Sex.MALE)
        );
        people.add(
                new Person("Ramki",29,"ramki.n@email.com",Sex.MALE)
        );
        people.add(
                new Person("Vinayaka",27,"vinayaka@email.com",Sex.MALE)
        );

        return people;

    }
}
