package Leetcode_83_Remove_Duplicates_from_Sorted_List;

import Singly_LinkedList.ListNode;

public class Solution4 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = deleteDuplicates(head.next);
        if(head.val == head.next.val){
            return head.next;
        }
        return head;
    }
}
