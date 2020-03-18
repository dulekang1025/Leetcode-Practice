package Leetcode_147_Insertion_Sort_List;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = dummy;
        while(head != null){
            ListNode t = head.next;
            cur = dummy;
            while(cur.next != null && cur.next.val < head.val){
                cur = cur.next;
            }
            // insert behind cur
            head.next = cur.next;
            cur.next = head;
            head = t;
        }
        return dummy.next;
    }
}
