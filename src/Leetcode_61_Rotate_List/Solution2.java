package Leetcode_61_Rotate_List;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        int len = 1;
        ListNode t = head, h = head;
        while(t.next != null){
            t = t.next;
            len++;
        }
        k = k > len ? k % len : k;
        if(k == len || len == 1 || k == 0) return head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        for(int i = 0; i < len - k - 1; i++){
            h = h.next;
        }
        ListNode temp = dummy.next;
        dummy.next = h.next;
        t.next = temp;
        h.next = null;
        return dummy.next;
    }
}
