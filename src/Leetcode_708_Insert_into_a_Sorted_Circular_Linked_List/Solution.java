package Leetcode_708_Insert_into_a_Sorted_Circular_Linked_List;

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node max = head, min = null;
        while(max.next != head && max.val <= max.next.val){
            max = max.next;
        }
        min = max.next;
        Node cur = min;
        if(insertVal <= min.val || insertVal >= max.val){
            Node node = new Node(insertVal);
            max.next = node;
            node.next = min;
        }else{
            while(cur.next.val < insertVal){
                cur = cur.next;
            }
            Node node = new Node(insertVal);
            Node temp = cur.next;
            cur.next = node;
            node.next = temp;
        }
        return head;
    }
}
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};