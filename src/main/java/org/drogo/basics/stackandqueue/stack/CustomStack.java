package org.drogo.basics.stackandqueue.stack;

public class CustomStack {

    protected int[] data;
    private static final int DEFAULT_SIZE = 10;
    int pointer = 0;

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public CustomStack() {
        this(DEFAULT_SIZE);
    }

    public boolean push(int item) throws StackException {
        if (isFull()) {
            System.out.println("Stack is full");
            return false;
            //throw new StackException("Stack is full");
        }

        data[pointer] = item;
        pointer++;
        return true;
    }

    public boolean isFull() {
        return pointer == data.length;
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public int pop() throws Exception {
        if (isEmpty()) {
            throw new StackException("Can not pop from an empty stack");
        }
        pointer--;
        int removed = data[pointer];

        return removed;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new StackException("Can not peek from an empty stack");
        }
        return data[pointer-1];
    }


}
