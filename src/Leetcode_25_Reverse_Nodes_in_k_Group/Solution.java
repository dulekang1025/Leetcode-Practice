package Leetcode_25_Reverse_Nodes_in_k_Group;

import Singly_LinkedList.ListNode;

import java.util.Stack;

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> s = new Stack<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode nxt = dummy.next;
        ListNode cur = dummy;
        while(nxt != null){
            for(int i = 0; i < k && nxt != null; i++){
                s.push(nxt);
                nxt = nxt.next;
            }
            if(s.size() != k) return dummy.next;
            while(!s.isEmpty()){
                cur.next = s.pop();
                cur = cur.next;
            }
            cur.next = nxt;
        }
        return dummy.next;
    }
}
