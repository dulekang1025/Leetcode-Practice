package Leetcode_21_Merge_Two_Sorted_Lists;

import Singly_LinkedList.ListNode;

class Solution2 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        ListNode p1 = l1, p2 = l2;
        while(p1 != null && p2 != null){
            if(p1.val <= p2.val){
                p.next = new ListNode(p1.val);
                p1 = p1.next;
            }else{
                p.next = new ListNode(p2.val);
                p2 = p2.next;
            }
            p = p.next;   // p != null
        }
        if(p1 != null){
            p.next = p1;  // p.next
        }else{
            p.next = p2;
        }
        return dummy.next;
    }
}
