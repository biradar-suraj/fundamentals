package org.drogo.basics.linkedlist;

public class CircularLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        tail.next = node;
        tail = node;

    }

    public void display() {
        Node current = head;
        if (head != null) {
            do {
                System.out.print(current.value + " -> ");
                current = current.next;
            } while (current != head);
        }
        System.out.println("HEAD");
    }

    public void delete(int value) {
        Node temp = head;
        if (temp == null) {
            return;
        }
        if (temp.value == value) {
            head = head.next;
            tail.next = head;
            return;
        }

        do {
            Node n = temp.next;
            if (n.value == value) {
                temp.next = n.next;
            }
            temp = temp.next;
        } while (temp != head);
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
