package org.drogo.basics.multithreading;

/* Extending Thread class and override run method */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Running in MyThread");
    }
}

