package org.drogo.basics.linkedlist;

public class GenericLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void insertFirst(T value) {
        Node<T> node = new Node<>(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;

    }

    public void insertLast(T value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node<T> node = new Node<>(value);
        tail.next = node;
        tail = node;

        size += 1;

    }

    public void display() {
        Node<T> current = head;

        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public void insert(int index, T value) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        if (index == size) {
            insertLast(value);
            return;
        }

        Node<T> temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;

        }

        Node<T> node = new Node<>(value);
        node.next = temp.next;
        temp.next = node;


        size += 1;
    }

    public GenericLinkedList() {
        this.size = 0;
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
