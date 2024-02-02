package org.drogo.basics.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                try {
                    System.out.println("Task " + taskId + " started");
                    System.out.println("Task " + taskId + " executed by Thread " +
                            Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

        }
        executorService.shutdown();

    }
}
