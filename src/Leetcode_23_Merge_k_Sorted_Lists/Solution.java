package Leetcode_23_Merge_k_Sorted_Lists;

import java.util.PriorityQueue;
import java.util.Queue;

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        for(ListNode head : lists){
            if(head != null) pq.add(head);
        }
        while(!pq.isEmpty()){
            ListNode smallest = pq.poll();
            if(smallest.next != null){
                pq.add(smallest.next);
            }
            p.next = smallest;
            p = p.next;
        }
        return dummy.next;
    }
}


