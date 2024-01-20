package org.drogo.basics.collection;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) throws ScriptException {
        PriorityQueue<Integer> priorityQueue= new PriorityQueue<>();
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(30);
        priorityQueue.offer(40);

        System.out.println(priorityQueue.size());
        System.out.println(priorityQueue.poll());
        System.out.println(priorityQueue.peek());



    }
}
