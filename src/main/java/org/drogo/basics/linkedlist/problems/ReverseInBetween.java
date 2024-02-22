package org.drogo.basics.linkedlist.problems;

/* 92. Reverse Linked List II
 *  https://leetcode.com/problems/reverse-linked-list-ii/description/ */
public class ReverseInBetween {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode previous = null;
        ListNode present = head;

        for (int i = 0; present != null && i < left - 1; i++) {
            previous = present;
            present = present.next;
        }

        ListNode last = previous;
        ListNode newend = present;

        //reverse between left and right
        ListNode next = present.next;
        for (int i = 0; present != null & i < right - left + 1; i++) {
            present.next = previous;
            previous = present;
            present = next;
            if (next != null) {
                next = next.next;
            }
        }
        if (last != null) {
            last.next = previous;
        } else {
            head = previous;
        }

        newend.next = present;
        return head;

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
        int left=2;
        int right=4;
        printList(head);
        ListNode reversedList = reverseBetween(head, left, right);
        printList(reversedList);



    }
}
