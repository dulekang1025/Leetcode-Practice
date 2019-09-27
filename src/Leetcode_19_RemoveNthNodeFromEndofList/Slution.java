package Leetcode_19_RemoveNthNodeFromEndofList;

import Singly_LinkedList.ListNode;

public class Slution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode last = dummy;
        if (dummy.next == null) {
            return dummy.next;
        }
        // 1. move the pre to the Nth node
        for (int i = 1; i <= n + 1; i++) {
            pre = pre.next;
        }
        // 2, move pre and last at same time until pre get to last node
        while (pre != null) {
            pre = pre.next;
            last = last.next;
        }
        // 3. remove last.next node
        last.next = last.next.next;

        return dummy.next;
    }
}
