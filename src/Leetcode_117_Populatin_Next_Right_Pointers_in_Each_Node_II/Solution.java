package Leetcode_117_Populatin_Next_Right_Pointers_in_Each_Node_II;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
public class Solution {
    public Node connect(Node root) {
        if(root == null) return root;
        return bfs(root);
    }
    public Node bfs(Node root){
        ArrayList<List<Node>> res = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        while(!queue.isEmpty()){
            List<Node> l = new LinkedList<Node>();
            size = queue.size();
            for(int i = 0; i < size; i++){
                Node curNode = queue.pop();
                l.add(curNode);
                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);
            }
            res.add(l);
        }
        conn(res);
        return root;
    }
    public void conn(ArrayList<List<Node>> res){
        for(List<Node> l : res){
            Node pre = null;
            for(Node n : l){
                if(l.size() == 1){
                    n.next = null;
                }
                else{
                    if(pre == null) pre = n;
                    else{
                        pre.next = n;
                        pre = n;
                    }
                }
            }
        }
    }
}
