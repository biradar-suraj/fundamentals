package org.drogo.basics.linkedlist.problems;

/* 148. Sort List
*  https://leetcode.com/problems/sort-list/description/ */
public class SortList {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMidNode(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummyHead.next;
    }

    public static ListNode getMidNode(ListNode head) {
        ListNode midPrev = null;
        while (head != null && head.next != null) {
            //midPrev = (midPrev == null) ? head : midPrev.next;
            if (midPrev == null) {
                midPrev = head;
            } else {
                midPrev = midPrev.next;
            }
            head = head.next.next;
        }
        ListNode mid = midPrev.next;
        midPrev.next = null;
        return mid;
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
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode sortedList = sortList(head);
        printList(sortedList);
    }
}
