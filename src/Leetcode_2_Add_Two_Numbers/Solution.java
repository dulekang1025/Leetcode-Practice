package Leetcode_2_Add_Two_Numbers;



import Singly_LinkedList.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int sum = 0;
        while(p1 != null || p2 != null){
            if(p1 != null){
                sum += p1.val;
                p1 = p1.next;
            }
            if(p2 != null){
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;

        }
        if(sum == 1){
            cur.next = new ListNode(1);
        }
        return result.next;

    }
}
