package org.drogo.basics.linkedlist.problems;

/* 142. Linked List Cycle II
   https://leetcode.com/problems/linked-list-cycle-ii/description/ */
public class LinkedListCycle2 {

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(fast==slow){
                break;
            }
        }

        if(fast==null || fast.next==null){
            return null;
        }

        slow=head;

        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);

        head.next.next.next.next = head.next;

        ListNode cycleStartNode =detectCycle(head);
        if(cycleStartNode==null){
            System.out.println("LinkedList does not have a cycle");
        }else{
            System.out.println("Cycle starts at node with value "+cycleStartNode.val);
        }

    }
}
