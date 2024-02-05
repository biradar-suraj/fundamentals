package org.drogo.basics.multithreading;

import java.util.concurrent.Callable;

/*  Callable tasks can only be executed using the ExecutorService
 *  Callable can throw Checked Exceptions
 * */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Running in MyCallable");
        return "Result";
    }
}
