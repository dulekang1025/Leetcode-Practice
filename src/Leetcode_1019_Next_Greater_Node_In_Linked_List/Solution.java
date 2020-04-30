package Leetcode_1019_Next_Greater_Node_In_Linked_List;

import Singly_LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextLargerNodes(ListNode head) {
        Stack<int[]> s = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        ListNode p = head;
        int size = 0;
        while(p != null){
            while(!s.isEmpty() && s.peek()[1] < p.val){
                map.put(s.pop()[0], p.val);
            }
            s.push(new int[]{size, p.val});
            p = p.next;
            size++;
        }
        p = head;
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = map.getOrDefault(i, 0);
            p = p.next;
        }
        return ans;
    }
}
