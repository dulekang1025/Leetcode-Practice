package Leetcode_99_Recover_Binary_Search_Tree;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        TreeNode x = null, y = null;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre != null && pre.val > root.val){
                y = root;
                if(x == null) x = pre;
                else break;
            }
            pre = root;
            root = root.right;
        }
        // swap
        int temp = x.val;
        x.val = y.val;
        y.val = temp;
    }
}