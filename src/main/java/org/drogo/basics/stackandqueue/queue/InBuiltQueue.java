package org.drogo.basics.stackandqueue.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class InBuiltQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(6);
        queue.add(5);
        queue.add(19);
        queue.add(1);
        queue.add(11);

        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue);

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(78);
        deque.addFirst(67);
        deque.addLast(89);
        System.out.println(deque);
        System.out.println(deque.removeLast());


    }
}
