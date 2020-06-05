package Leetcode_382_Linked_List_Random_Node;

import Singly_LinkedList.ListNode;

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    Random rand;
    ListNode h;
    ListNode t;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        h = head;
        t = head;
        rand = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        h = t;
        int count = 0;
        int res = h.val;
        while(h != null){
            count++;
            if(rand.nextInt(count) == 0)
                res = h.val;
            h = h.next;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
