package org.drogo.basics.linkedlist.problems;

/* 876. Middle of the Linked List
 *  https://leetcode.com/problems/middle-of-the-linked-list/description/ */
public class MiddleOfTheLinkedList {
    public static ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode middle = findMiddleNode(head);
        System.out.println("Middle node with value: " + middle.val);

    }

}
