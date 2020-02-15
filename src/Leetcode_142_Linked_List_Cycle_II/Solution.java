package Leetcode_142_Linked_List_Cycle_II;

import Singly_LinkedList.ListNode;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow,fast;
        slow = head;
        fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
