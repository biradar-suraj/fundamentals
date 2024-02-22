package org.drogo.basics.linkedlist.problems;

/* 206. Reverse Linked List
*  https://leetcode.com/problems/reverse-linked-list/description/ */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode previous, present, next;
        previous = null;
        present = head;
        next = present.next;

        while (present != null) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null) {
                next = next.next;
            }

        }
        return previous;

    }

    public static void printList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        printList(head);
        ListNode reverseList = reverseList(head);
        printList(reverseList);
    }
}
