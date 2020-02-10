package Leetcode_24_Swap_Nodes_in_Pairs;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null && prev.next.next != null){
            ListNode t = prev.next.next;
            prev.next.next = t.next;
            t.next = prev.next;
            prev.next = t;
            prev = t.next;
        }
        return dummy.next;
    }
}
