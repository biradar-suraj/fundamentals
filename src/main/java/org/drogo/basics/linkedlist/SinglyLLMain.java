package org.drogo.basics.linkedlist;

public class SinglyLLMain {
    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(8);
        linkedList.insertFirst(17);

        linkedList.display();
        linkedList.insertLast(11);
        linkedList.insertLast(22);
        linkedList.display();
        linkedList.insert(9, 3);
        System.out.println(linkedList.deleteFirst());
        linkedList.display();
        System.out.println(linkedList.deleteLast());
        linkedList.display();
        System.out.println(linkedList.delete(3));


    }
}
