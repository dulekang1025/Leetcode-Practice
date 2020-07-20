package Leetcode_83_Remove_Duplicates_from_Sorted_List;

import Singly_LinkedList.ListNode;

public class Solution3 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            head.next = head.next.next;
        }
        return head;
    }
}
