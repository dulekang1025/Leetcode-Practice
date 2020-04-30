package Leetcode_1171._Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List;

import Singly_LinkedList.ListNode;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        int sum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode();
        dummy.next = head;
        map.put(0, dummy);
        while(head != null){
            sum += head.val;
            if(map.containsKey(sum)){
                // remove sums from map first
                int tempSum = sum;
                ListNode node = map.get(sum);
                ListNode toDelete = node.next;
                while(toDelete != head){
                    tempSum += toDelete.val;
                    map.remove(tempSum);
                    toDelete = toDelete.next;
                }
                // delete node
                head = head.next;
                node.next = head;
            }else{
                map.put(sum, head);
                head = head.next;
            }
        }
        return dummy.next;
    }
}
