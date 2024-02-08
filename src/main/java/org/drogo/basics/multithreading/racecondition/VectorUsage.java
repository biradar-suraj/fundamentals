package org.drogo.basics.multithreading.racecondition;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class VectorUsage {
    public static void main(String[] args) throws InterruptedException {

        int size = 1000000;
        List<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
        }

        long end = System.currentTimeMillis();
        System.out.println("Added " + size + " elements to ArrayList: " + (end - start) + "ms");

        List<Integer> vector = new Vector<>();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            vector.add(i);
        }
        end = System.currentTimeMillis();

        System.out.println("Added " + size + " elements to Vector: " + (end - start) + "ms");

        /*  Multithreading
         *  Unpredictable results for ArrayList, because operations on ArrayList are not synchronised/not thread safe
         *  To solve this problem use synchronizedList from Collections
         *  */
        List<Integer> multithreadedList = Collections.synchronizedList(new ArrayList<>());
        //List<Integer> multithreadedList = new ArrayList<>();
        start = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedList.add(i);
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        end = System.currentTimeMillis();
        System.out.println("Added elements to ArrayList in multithreaded way: " + (end - start) + "ms");
        System.out.println("Arraylist size: " + multithreadedList.size());

        /*  Operations on vector are synchronised/ thread safe
         *  Thread safety comes at performance cost
         * */
        List<Integer> multithreadedVector = new Vector<>();
        start = System.currentTimeMillis();
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < size; i++) {
                multithreadedVector.add(i);
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();
        end = System.currentTimeMillis();
        System.out.println("Added elements to Vector in multithreaded way: " + (end - start) + "ms");
        System.out.println("Vector size: " + multithreadedVector.size());


    }
}
