package org.drogo.basics.linkedlist;

public class GenericLLMain {
    public static void main(String[] args) {
        GenericLinkedList<Integer> linkedList = new GenericLinkedList<>();

        linkedList.insertFirst(5);
        linkedList.insertFirst(10);
        linkedList.insertFirst(15);
        linkedList.insertFirst(20);
        linkedList.display();

        linkedList.insertLast(25);
        linkedList.display();
        linkedList.insert(2, 55);
        linkedList.display();
    }
}
