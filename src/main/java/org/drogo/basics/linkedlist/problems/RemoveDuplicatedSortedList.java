package org.drogo.basics.linkedlist.problems;

/* 83. Remove Duplicates from Sorted List
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 * */
public class RemoveDuplicatedSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
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
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next= new ListNode(2);
        ListNode result = deleteDuplicates(head);
        printList(result);

    }
}
