package org.drogo.basics.multithreading.challenge;

public class MainClass {
    public static void main(String[] args) {

        EvenThread evenThread = new EvenThread("EvenThread");
        Thread oddThread = new Thread(new OddRunnable(), "OddThread");

        oddThread.start();
        evenThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        oddThread.interrupt();


    }
}
