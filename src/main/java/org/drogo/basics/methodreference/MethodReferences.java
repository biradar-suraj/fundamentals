package org.drogo.basics.methodreference;

import org.drogo.basics.lambda.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferences {

    public static void main(String[] args) {

        List<Person> people= Person.generateDefaultList();

        Person a= people.get(0);
        Person b= people.get(1);
        Person c= people.get(2);

        people.forEach(person -> System.out.println(person));

        people.forEach(System.out::println);

        people.stream()
                .map(Person::getAge)
                .forEach(System.out::println);

        List<String> names = Arrays.asList("Brahma", "Vishnu", "Mahesha");

        List<Person> newPersonList = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());

        System.out.println(newPersonList);

        people.forEach(a::printName);
        people.forEach(b::printName);
        people.forEach(c::printName);


    }
}
