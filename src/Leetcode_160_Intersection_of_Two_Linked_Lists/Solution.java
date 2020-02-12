package Leetcode_160_Intersection_of_Two_Linked_Lists;

import Singly_LinkedList.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        int n1 = 0;
        int n2 = 0;
        while(p1.next != null){
            p1 = p1.next;
            n1 += 1;
        }
        while(p2.next != null){
            p2 = p2.next;
            n2 += 1;
        }
        p1 = headA;
        p2 = headB;
        if(n1 > n2){
            for(int i = 0; i < (n1 - n2); i++){
                p1 = p1.next;
            }
        }
        if(n1 < n2){
            for(int i = 0; i < (n2 - n1); i++){
                p2 = p2.next;
            }
        }
        while(p1.next != null && p2.next != null){
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        // deal with last node
        if(p1.next == null && p2.next == null){
            if(p1 == p2) return p1;
        }
        return null;
    }
}
