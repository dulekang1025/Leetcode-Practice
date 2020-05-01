package Leetcode_725_Split_Linked_List_in_Parts;

import Singly_LinkedList.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        int length = 0;
        ListNode p = root;
        while(p != null){
            length += 1;
            p = p.next;
        }
        int avg = length / k;
        int carry = length % k;
        System.out.println(avg + " " + carry);
        for(int i = 0; i < k; i++){
            ans[i] = root;
            int len = i < carry ? avg + 1 : avg;
            for(int j = 1; j < len; j++){
                root = root.next;
            }
            if(root != null){
                ListNode t = root.next;
                root.next = null;
                root = t;
            }
        }
        return ans;
    }
}
