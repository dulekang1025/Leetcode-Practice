package Leetcode_589_Nary_Tree_Preorder_Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
    public List<Integer> preorder(Node root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Node cur = root;
        Stack<Node> s = new Stack<>();
        s.push(cur);
        while(cur != null && !s.isEmpty()){
            cur = s.pop();
            result.add(cur.val);
            int n = cur.children.size() - 1;
            while(n >= 0){
                if(cur.children.get(n) != null){
                    s.push(cur.children.get(n));
                }
                n--;
            }
        }
        return result;
    }
}
