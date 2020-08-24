package Leetcode_510_Inorder_Successor_in_BST_II;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public Node inorderSuccessor(Node node) {
        Node root = node;
        Node pre = null;
        while(root.parent != null){
            root = root.parent;
        }
        Deque<Node> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root == node){
                pre = root;
            }else if(pre == node){
                return root;
            }
            root = root.right;
        }
        return null;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
