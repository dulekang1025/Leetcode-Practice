package Leetcode_83_Remove_Duplicates_from_Sorted_List;

import Singly_LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode next;

        while(cur != null){
            next = cur;
            if(next.val == cur.val){
                next = next.next;
                while(next != null && cur.val == next.val){
                    next = next.next;
                }
                cur.next = next;
                cur = cur.next;
            }
        }
        return head;
    }
}
