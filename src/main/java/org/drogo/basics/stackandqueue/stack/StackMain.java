package org.drogo.basics.stackandqueue.stack;

public class StackMain {
    public static void main(String[] args) throws Exception {
        CustomStack stack = new CustomDynamicStack(5);

        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        stack.push(66);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
