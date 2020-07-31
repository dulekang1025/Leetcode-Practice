package Leetcode_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while(head != null){
            res *= 2;
            res += head.val;
            head = head.next;
        }
        return res;
    }
}
