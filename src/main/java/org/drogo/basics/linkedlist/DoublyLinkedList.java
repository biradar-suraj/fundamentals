package org.drogo.basics.linkedlist;

public class DoublyLinkedList {
    private Node head;
    //private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.previous = null;
        if (head != null) {
            head.previous = node;
        }
        head = node;
        size += 1;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            node.previous = null;
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        node.next = null;
        temp.next = node;
        node.previous = temp;
        size++;

    }

    public void insert(int value, int index) {
        if(index>size){
            System.out.println("Index does not exist");
            return;
        }
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;

        }
        Node node = new Node(value);
        node.next = temp.next;
        temp.next = node;
        node.previous = temp;
        if (node.next != null) {
            node.next.previous = node;
        }

    }

    public void display() {
        Node current = head;
        Node last = null;
        while (current != null) {
            System.out.print(current.value + " -> ");
            last = current;
            current = current.next;
        }
        System.out.println("END");

        System.out.print("Reverse order:");
        while (last != null) {
            System.out.print(last.value + " -> ");
            last = last.previous;
        }
        System.out.println("END");

    }


    private class Node {
        private int value;
        private Node next;
        private Node previous;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}
