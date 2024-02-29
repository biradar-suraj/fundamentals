package org.drogo.basics.stackandqueue.problems;

import java.util.Stack;

/*  232. Implement Queue using Stacks
 *   https://leetcode.com/problems/implement-queue-using-stacks/description/ */
public class QueueUsingStacks {
    private final Stack<Integer> first;
    private final Stack<Integer> second;

    public QueueUsingStacks() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void push(int x) {
        first.push(x);

    }

    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int removed = second.pop();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return removed;

    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        int peeked = second.peek();

        while (!second.isEmpty()) {
            first.push(second.pop());
        }
        return peeked;

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
