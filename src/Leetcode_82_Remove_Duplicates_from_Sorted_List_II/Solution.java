package Leetcode_82_Remove_Duplicates_from_Sorted_List_II;

import Singly_LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null){
            ListNode cur = prev.next;
            while(cur.next != null && cur.next.val == cur.val){
                cur =cur.next;
            }
            if(cur != prev.next) prev.next = cur.next;
            else prev = prev.next;
        }
        return dummy.next;
    }
}
