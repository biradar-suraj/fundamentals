package org.drogo.basics.lambda;

import java.util.List;
import java.util.function.Predicate;

public class LambdaExp {

    static class CheckPersonEligibleForSelectiveSearch implements CheckPerson{

        @Override
        public boolean test(Person person) {
            return person.gender == Sex.MALE &&
                    person.getAge() >= 20 &&
                    person.getAge() <= 28;
        }
    }

    //With our funcation interface CheckPerson
    public static void printPeople(List<Person> people, CheckPerson tester){
        for (Person person : people) {
            if(tester.test(person)){
                person.printPerson();
            }

        }

    }

    //With Predicate
    public static void printPeopleWithPredicate(List<Person> people, Predicate<Person> tester){
        for (Person person : people) {
            if(tester.test(person)){
                person.printPerson();
            }

        }

    }

    public static void printPersonWithinAgeRange(List<Person> people, int low, int high){
        for (Person person : people) {
            if(low<=person.getAge() && person.getAge()<high){
                person.printPerson();
            }

        }

    }

    public static void printPersonOlderThan(List<Person> people, int age){
        for (Person p: people) {
            if(p.getAge() >= age){
                p.printPerson();
            }

        }

    }

    public static void main(String[] args) {
        List<Person> people = Person.generateDefaultList();

        /*
        printPersonOlderThan(people,28);
        printPersonWithinAgeRange(people,20,28);
        printPeople(people, new CheckPersonEligibleForSelectiveSearch());
        */

        printPeople(people, new CheckPerson() {
            @Override
            public boolean test(Person person) {
                return person.gender == Sex.MALE &&
                        person.getAge() >= 20 &&
                        person.getAge() <= 28;
            }
        });

        printPeople(people, person-> person.gender == Sex.MALE && person.getAge() >= 20 && person.getAge() <= 28);
    }
}
