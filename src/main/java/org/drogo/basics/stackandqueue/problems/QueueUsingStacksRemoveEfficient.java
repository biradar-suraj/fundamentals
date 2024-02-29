package org.drogo.basics.stackandqueue.problems;

import java.util.Stack;

/*  232. Implement Queue using Stacks (remove efficient approach
 *   https://leetcode.com/problems/implement-queue-using-stacks/description/ */
public class QueueUsingStacksRemoveEfficient {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public QueueUsingStacksRemoveEfficient() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void push(int x) {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        first.push(x);

        while (!second.isEmpty()) {
            first.push(second.pop());
        }

    }

    public int pop() {
        return first.pop();
    }

    public int peek() {
        return first.peek();
    }

    public boolean empty() {
        return first.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push(5);
        queue.push(4);
        queue.push(6);

        System.out.println(queue.peek());
        System.out.println(queue.pop());

        System.out.println(queue.peek());
        System.out.println(queue.pop());

        System.out.println(queue.peek());
        System.out.println(queue.pop());

        System.out.println(queue.empty());
    }
}
