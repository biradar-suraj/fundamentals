package org.drogo.basics.collection.arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Integer> list= new ArrayList<>(10);
        list.add(69);
        list.add(34);
        list.add(73);
        list.add(82);
        System.out.println(list);

        list.set(3,69);
        list.remove(2);
        System.out.println(list);

        for (int i = 0; i < 5; i++) {
            list.add(in.nextInt());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }





    }
}
