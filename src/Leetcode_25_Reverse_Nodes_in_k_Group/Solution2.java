package Leetcode_25_Reverse_Nodes_in_k_Group;

import Singly_LinkedList.ListNode;

class Solution2 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode nxt = dummy.next;
        ListNode cur = dummy.next;
        ListNode prev = dummy;
        for(int i = 1; nxt != null; i++){
            nxt = nxt.next;
            if(i % k == 0){
                reverse(prev, cur, nxt);
                prev = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
    private void reverse(ListNode prev, ListNode cur, ListNode nxt){
        while(cur.next != nxt){
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = prev.next;
            prev.next = t;
        }
    }
}
