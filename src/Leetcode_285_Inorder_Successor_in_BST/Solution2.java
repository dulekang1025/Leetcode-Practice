package Leetcode_285_Inorder_Successor_in_BST;

import TreeNode.TreeNode;

public class Solution2 {
    TreeNode pre = null;
    TreeNode ans = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        TreeNode left = inorderSuccessor(root.left, p);
        if(root == p){
            pre = root;
        }else if(pre != null && ans == null) ans = root;
        TreeNode right = inorderSuccessor(root.right, p);
        return ans;
    }
}
