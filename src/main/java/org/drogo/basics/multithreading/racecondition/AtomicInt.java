package org.drogo.basics.multithreading.racecondition;

import java.util.concurrent.atomic.AtomicInteger;

/* Using int would result in race-condition when multiple threads operate on it
 *  this can be resolved by making use of AtomicInteger
 * */
public class AtomicInt {
    public static void main(String[] args) {
        ShareCounter shareCounter = new ShareCounter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                shareCounter.increament();

            }
            System.out.println("Thread t1 completed");
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                shareCounter.increament();
            }
            System.out.println("Thread t2 completed");
        });

        t1.start();
        t2.start();

        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + shareCounter.getCount());

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                shareCounter.incrementAtomicCounter();
            }
            System.out.println("Thread t3 completed");
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                shareCounter.incrementAtomicCounter();
            }
            System.out.println("Thread t4 completed");
        });

        t3.start();
        t4.start();

        try {

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final atomic count: " + shareCounter.getAtomicCount());

    }
}

class ShareCounter {
    int count;
    AtomicInteger atomicCounter = new AtomicInteger(0);

    public void increament() {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void incrementAtomicCounter() {
        atomicCounter.incrementAndGet();
    }

    public int getAtomicCount() {
        return atomicCounter.get();
    }

}
