package Leetcode_445_Add_Two_Numbers_II;

import Singly_LinkedList.ListNode;

import java.util.Stack;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1 != null){
            s1.push(p1.val);
            p1 = p1.next;
        }
        while(p2 != null){
            s2.push(p2.val);
            p2 = p2.next;
        }
        int sum = 0;
        ListNode res = new ListNode(0);
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(!s1.isEmpty()) sum += s1.pop();
            if(!s2.isEmpty()) sum += s2.pop();
            res.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = res;
            res = head;
            sum /= 10;
        }
        return res.val == 0 ? res.next : res;
    }
}
