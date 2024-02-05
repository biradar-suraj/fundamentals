package org.drogo.basics.multithreading;

/*  Runnable tasks can be executed using the Thread class or the ExecutorService
    Runnable cannot throw checked exceptions
*/
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Running in MyRunnable");
    }
}

