package Leetcode_203_Remove_Linked_List_Elements;

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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        while(head.val == val && head.next != null){
            head = head.next;
        }
        if(head.next == null){
            if(head.val == val) return null;
            if(head.val != val) return head;
        }
        ListNode s = head;
        ListNode f = head.next;
        while(s.next != null){
            if(f.val == val){
                if(f.next == null){
                    s.next = null;
                }
                else{
                    f = f.next;
                    s.next = f;
                }
            }
            else{
                s = s.next;
                f = f.next;
            }
        }
        return head;
    }
}
