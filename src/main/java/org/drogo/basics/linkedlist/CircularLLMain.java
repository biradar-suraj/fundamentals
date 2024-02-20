package org.drogo.basics.linkedlist;

public class CircularLLMain {
    public static void main(String[] args) {
        CircularLinkedList linkedList = new CircularLinkedList();
        linkedList.insert(13);
        linkedList.insert(3);
        linkedList.insert(17);
        linkedList.insert(19);
        linkedList.insert(28);

        linkedList.display();

        linkedList.delete(17);
        linkedList.display();

    }


}
