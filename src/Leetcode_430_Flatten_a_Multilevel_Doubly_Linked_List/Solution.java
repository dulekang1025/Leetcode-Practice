package Leetcode_430_Flatten_a_Multilevel_Doubly_Linked_List;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

import java.util.Stack;

class Solution {
    public Node flatten(Node head) {
        Stack<Node> s = new Stack<>();
        Node cur = head;
        while(cur != null){
            if(cur.child != null){
                if(cur.next != null){
                    s.push(cur.next);
                }
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }else if(cur.next == null && !s.isEmpty()){
                cur.next = s.pop();
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
