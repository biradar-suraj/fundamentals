package org.drogo.basics.linkedlist;

public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertLast(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;

        size += 1;
    }

    public void insert(int value, int index) {
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
        Node node = new Node(value, temp.next);
        temp.next = node;

        size += 1;

    }

    public int deleteFirst() {
        int value = head.value;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return value;
    }

    private Node get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public Node find(int value) {
        Node current = head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
        }
        return null;
    }

    public int deleteLast() {
        if (size <= 1) {
            return deleteFirst();
        }

        Node secondLast = get(size - 2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;

        return value;
    }

    public int delete(int index) {
        if (index == 0) {
            return deleteFirst();
        }
        if (index == size - 1) {
            return deleteLast();
        }
        Node previous = get(index - 1);
        int value = previous.next.value;
        previous.next = previous.next.next;
        return value;
    }

    // insert using recursion
    public void insertRecursively(int value, int index) {
        head = insertRecursively(value, index, head);

    }

    private Node insertRecursively(int value, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(value, node);
            size++;
            return temp;
        }

        node.next = insertRecursively(value, index - 1, node.next);
        return node;
    }

    /* 21. Merge Two Sorted Lists
    *  https://leetcode.com/problems/merge-two-sorted-lists/description/
     */
    public static SinglyLinkedList mergeTwoLists(SinglyLinkedList first, SinglyLinkedList second) {
        SinglyLinkedList result = new SinglyLinkedList();
        Node f = first.head;
        Node s = second.head;

        while (f != null && s != null) {
            if (f.value < s.value) {
                result.insertLast(f.value);
                f = f.next;
            } else {
                result.insertLast(s.value);
                s = s.next;
            }
        }

        while (f != null) {
            result.insertLast(f.value);
            f = f.next;
        }
        while (s != null) {
            result.insertLast(s.value);
            s = s.next;
        }
        return result;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
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
    }
}
