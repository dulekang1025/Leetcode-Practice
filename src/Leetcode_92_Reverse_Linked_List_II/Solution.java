package Leetcode_92_Reverse_Linked_List_II;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur,t = null;
        for(int i = 0; i < m - 1; i++){
            pre = pre.next;
        }
        cur = pre.next;
        for(int i = 0; i < (n - m); i++){
            t = cur.next;
            cur.next = t.next;
            t.next = pre.next;
            pre.next = t;
        }
        return dummy.next;
    }
}
