package Leetcode_83_Remove_Duplicates_from_Sorted_List;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode prev = head;
        ListNode cur;
        while(prev.next != null){
            cur = prev;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if(prev != cur) prev.next = cur.next;
            else prev = prev.next;
        }
        return head;
    }
}
