package Leetcode_429_Nary_Tree_Level_Order_Traversal;


import java.util.LinkedList;
import java.util.List;

// Definition for a Node.
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val,List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//}

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<Node>();
        if(root == null) return res;
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> l = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node cur = queue.pop();
                l.add(cur.val);
                if(!cur.children.isEmpty()){
                    for(Node c : cur.children){
                        queue.offer(c);
                    }
                }
            }
            res.add(l);
        }
        return res;
    }
}