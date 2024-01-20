package org.drogo.basics.oop.cloning;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Person person = new Person(30, "Suraj");
        Person twin = person.clone();
        System.out.println(twin.name);

        System.out.println(Arrays.toString(person.arr));
        twin.arr[0] = 100;
        System.out.println(Arrays.toString(twin.arr));
        System.out.println(Arrays.toString(person.arr));
    }
}
