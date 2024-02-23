package org.drogo.basics.linkedlist.problems;

/* 143. Reorder List
 *  https://leetcode.com/problems/reorder-list/description/ */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = findMid(head);
        ListNode secondHead = reverseList(mid);
        ListNode firstHead = head;

        while (firstHead != null && secondHead != null) {
            ListNode temp = firstHead.next;
            firstHead.next = secondHead;
            firstHead = temp;

            temp = secondHead.next;
            secondHead.next = firstHead;
            secondHead = temp;

        }

        //next of tail to null
        if (firstHead != null) {
            firstHead.next = null;
        }

    }

    public static ListNode findMid(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode prev = null;
        ListNode present = head;
        ListNode next = present.next;

        while (present != null) {
            present.next = prev;
            prev = present;
            present = next;

            if (next != null) {
                next = next.next;
            }
        }
        return prev;
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
        printList(head);

        reorderList(head);
        printList(head);

    }
}
