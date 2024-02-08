package org.drogo.basics.multithreading.basics;

public class ThreadInteraction {
    public static void main(String[] args) {
        System.out.println("Main thread running");
        try {
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread myThread = new Thread(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " should take 10 dots to run. ");
            for (int i = 0; i < 10; i++) {
                System.out.println(" . ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("\n Oops! " + threadName + " interrupted. ");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + threadName + " completed. ");
        });


        Thread installThread = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(250);
                    System.out.println("Installation step " + (i + 1) + " is completed");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "InstallThread");

        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            while (myThread.isAlive()) {
                try {
                    Thread.sleep(1000);

                    if (System.currentTimeMillis() - now > 2000) {
                        myThread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println(myThread.getName() + " starting ");
        myThread.start();
        threadMonitor.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!myThread.isInterrupted()) {
            installThread.start();
        } else {
            System.out.println("Previous thread was interrupted " +
                    installThread.getName() + " can't run");
        }

    }
}
