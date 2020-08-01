package Leetcode_98_Validate_Binary_Search_Tree;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        int preValue = 0;
        boolean f = true;
        if(root == null) return true;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(f){
                preValue = root.val;
                f = false;
            }else{
                if(root.val <= preValue) return false;
                preValue = root.val;
            }
            root = root.right;
        }
        return true;
    }
}
