package Leetcode_21_Merge_Two_Sorted_Lists;

import Singly_LinkedList.ListNode;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode temp;
        if(l1.val > l2.val){
            temp = l2;
            temp.next = mergeTwoLists(l1,l2.next);
            return temp;
        }
        else {
            temp = l1;
            temp.next = mergeTwoLists(l1.next,l2);
            return temp;
        }
    }
}
