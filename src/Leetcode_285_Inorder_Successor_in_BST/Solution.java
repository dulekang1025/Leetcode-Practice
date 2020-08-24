package Leetcode_285_Inorder_Successor_in_BST;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        if(root == null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root == p){
                pre = root;
            }else if(pre != null){
                return root;
            }
            root = root.right;
        }
        return null;
    }
}
