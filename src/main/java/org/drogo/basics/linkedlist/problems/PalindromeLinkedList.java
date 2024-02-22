package org.drogo.basics.linkedlist.problems;

/* 234. Palindrome Linked List
 *  https://leetcode.com/problems/palindrome-linked-list/description/ */
public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        ListNode mid = findMid(head);
        ListNode reversedHead = reverseList(mid);

        while (head != null && reversedHead != null) {
            if (head.val != reversedHead.val) {
                break;
            }
            head = head.next;
            reversedHead = reversedHead.next;
        }
        return head == null || reversedHead == null;


    }

    public static ListNode findMid(ListNode head) {
        if (head == null) return head;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode previous = null;
        ListNode present = head;
        ListNode next = present.next;

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
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        printList(head);
        System.out.println(isPalindrome(head));

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        printList(head1);
        System.out.println(isPalindrome(head1));


    }
}
