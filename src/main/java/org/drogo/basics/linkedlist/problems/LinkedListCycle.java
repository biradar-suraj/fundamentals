package org.drogo.basics.linkedlist.problems;

/* 141. Linked List Cycle
 *  https://leetcode.com/problems/linked-list-cycle/description/ */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /* Find length of the cycle */
    public static int findCycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return 0;
        }

        int cycleLength = 1;
        fast = fast.next;
        while (fast != slow) {
            fast = fast.next;
            cycleLength++;
        }
        return cycleLength;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        head.next.next.next.next = head.next.next;

        System.out.println(hasCycle(head));
        System.out.println(findCycleLength(head));

    }
}
