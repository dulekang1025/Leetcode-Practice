package Leetcode_82_Remove_Duplicates_from_Sorted_List_II;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        if(head.val == head.next.val){
            ListNode cur = head;
            while(cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            head = deleteDuplicates(cur.next);
        }else{
            head.next = deleteDuplicates(head.next);
        }
        return head;
    }
}
