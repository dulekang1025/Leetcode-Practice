package Leetcode_206_Reverse_Linked_List;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = null;
        ListNode p = null;
        dummy.next = head;
        while(head.next != null){
            p = dummy.next;
            cur = head.next;
            dummy.next = cur;
            head.next = cur.next;
            cur.next = p;
        }
        return dummy.next;
    }
}
