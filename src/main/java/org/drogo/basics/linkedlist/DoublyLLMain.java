package org.drogo.basics.linkedlist;

public class DoublyLLMain {
    public static void main(String[] args) {
        DoublyLinkedList linkedList= new DoublyLinkedList();
        linkedList.insertFirst(8);
        linkedList.insertFirst(3);
        linkedList.insertFirst(7);
        linkedList.insertFirst(10);
        linkedList.display();
        linkedList.insertLast(20);
        linkedList.display();
        linkedList.insert(21,6);
        linkedList.display();

    }
}
