package org.drogo.basics.multithreading;

import java.util.concurrent.*;

public class ImprovedThreadMain {
    public static void main(String[] args) {
        ExecutorService execService = Executors.newFixedThreadPool(2);

        Runnable runnableTask = () -> System.out.println("Running Runnable Task");
        execService.submit(runnableTask);

        Callable<String> callableTask = () -> {
            // simulate some work
            System.out.println("Running Callable Task");
            Thread.sleep(1000);
            return "Result of Callable Task";
        };

        Future<String> future = execService.submit(callableTask);

        // wait for Callable to complete and retrieve the result

        try {
            String callableResult = future.get();
            System.out.println(callableResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            execService.shutdown();
        }

    }
}
