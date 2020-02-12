package Leetcode_61_Rotate_List;

import Singly_LinkedList.ListNode;

class Solution {
    // Caution: what if k is very large???
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode h,p,t;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        h = head;
        int l = 1;
        while(h.next != null){
            l += 1;
            h = h.next;
        }
        k %= l;
        for(int i = 0; i < k; i++){
            h = dummy.next;
            p = h;
            t = h.next;
            while(t.next != null){
                p = p.next;
                t = t.next;
            }
            t.next = h;
            p.next = null;
            dummy.next = t;
        }
        return dummy.next;
    }
}
