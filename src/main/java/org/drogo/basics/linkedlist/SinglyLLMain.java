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

        linkedList.insertRecursively(10, 2);
        linkedList.display();

        /* Merge two sorted lists */
        SinglyLinkedList first = new SinglyLinkedList();
        first.insertLast(1);
        first.insertLast(3);
        first.insertLast(5);
        first.display();

        SinglyLinkedList second = new SinglyLinkedList();
        second.insertLast(1);
        second.insertLast(2);
        second.insertLast(9);
        second.insertLast(14);
        second.display();

        SinglyLinkedList result = SinglyLinkedList.mergeTwoLists(first, second);
        result.display();


    }
}
