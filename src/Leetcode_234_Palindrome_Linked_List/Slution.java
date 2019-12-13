package Leetcode_234_Palindrome_Linked_List;

import Singly_LinkedList.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode cur = head;
        while(cur != null){
            s.push(cur);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            if(s.pop().val != cur.val) return false;
            cur = cur.next;
        }
        return true;
    }
}
