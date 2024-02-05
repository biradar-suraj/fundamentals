package org.drogo.basics.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*  By separating the concerns of defining the work (Runnable) from managing the execution (Thread),
    Java provides a clean separation of responsibilities and allows for greater flexibility in how tasks are scheduled and executed.
    This design pattern is known as the Strategy Pattern,
    where the Runnable is the strategy for executing the task, and the Thread is the context that controls the execution.
*/
public class ThreadMain {
    public static void main(String[] args)
            throws ExecutionException, InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        /*Runnable tasks can be executed using the Thread class or the ExecutorService*/
        MyRunnable runnableTask = new MyRunnable();
        Thread t1 = new Thread(runnableTask);
        t1.start();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(runnableTask);
        //executorService.shutdown();

        MyCallable callableTask = new MyCallable();
        Future<String> future = executorService.submit(callableTask);
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();


    }
}
