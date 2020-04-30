package Leetcode_817_Linked_List_Components;

import Singly_LinkedList.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int n : G) set.add(n);
        while(head != null){
            if(set.contains(head.val)){
                ans++;
                while(head != null && set.contains(head.val)) head = head.next;
            }else{
                head = head.next;
            }
        }
        return ans;
    }
}
