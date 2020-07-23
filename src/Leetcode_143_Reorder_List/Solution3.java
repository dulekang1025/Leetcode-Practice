package Leetcode_143_Reorder_List;

import Singly_LinkedList.ListNode;

class Solution3 {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode slow = head, fast = head, p = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode q = reverse(slow.next);
        ListNode cur = q;
        slow.next = null;
        while(p != null && q != null){
            ListNode temp_p = p.next;
            ListNode temp_q = q.next;
            p.next = q;
            q.next = temp_p;
            p = temp_p;
            q = temp_q;
        }
        return;
    }
    private ListNode reverse(ListNode q){
        if(q == null || q.next == null) return q;
        ListNode newHead = reverse(q.next);
        q.next.next = q;
        q.next = null;
        return newHead;
    }
}
