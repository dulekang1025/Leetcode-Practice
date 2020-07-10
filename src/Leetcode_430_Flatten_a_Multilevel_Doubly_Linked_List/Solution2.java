package Leetcode_430_Flatten_a_Multilevel_Doubly_Linked_List;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public Node flatten(Node head) {
        if(head == null) return head;
        Node cur = head;
        Deque<Node> stack = new ArrayDeque<>();
        while(true){
            if(cur.child != null){
                if(cur.next != null){
                    stack.push(cur.next);
                }
                cur.next = cur.child;
                cur.child = null;
                cur.next.prev = cur;
            }
            if(cur.next != null){
                cur = cur.next;
            }else if(!stack.isEmpty()){
                cur.next = stack.pop();
                cur.next.prev = cur;
                cur = cur.next;
            }else{
                return head;
            }
        }
    }
}
