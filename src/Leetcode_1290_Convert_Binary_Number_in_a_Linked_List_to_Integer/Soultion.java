package Leetcode_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import Singly_LinkedList.ListNode;

class Solution {
    public int getDecimalValue(ListNode head) {
        int n = 0;
        int res = 0;
        ListNode p = head;
        while(p.next != null){
            p = p.next;
            n += 1;
        }
        p = head;
        while(p != null){
            res += p.val * Math.pow(2,n);
            n--;
            p = p.next;
        }
        return res;
    }
}
