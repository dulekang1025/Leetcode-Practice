package Leetcode_1019_Next_Greater_Node_In_Linked_List;

import Singly_LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution2 {
    public int[] nextLargerNodes(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode p = head;
        int size = 0;
        while(p != null){
            while(!s.isEmpty() && s.peek().val < p.val){
                map.put(s.pop(), p.val);
            }
            s.push(p);
            p = p.next;
            size++;
        }
        p = head;
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = map.getOrDefault(p, 0);
            p = p.next;
        }
        return ans;
    }
}
