package Leetcode_86_Partition_List;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        ListNode newHead = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        ListNode p_newhead = newHead;
        while(p != null && p.next != null){
            if(p.next.val < x){
                p_newhead.next = p.next;
                p.next = p.next.next;
                p_newhead = p_newhead.next;
            }else{
                p = p.next;
            }
        }
        p_newhead.next = dummy.next;
        dummy.next = newHead.next;
        return dummy.next;
    }
}
