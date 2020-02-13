package Leetcode_2_Add_Two_Numbers;

import Singly_LinkedList.ListNode;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        int sum = 0;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(l1 != null || l2 != null){
            if(l1 != null) sum += l1.val;
            if(l2 != null) sum += l2.val;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(sum > 0) cur.next = new ListNode(1);
        return dummy.next;
    }
}
