package Leetcode_897_Increasing_Order_Search_Tree;

import TreeNode.TreeNode;

class Solution2 {
    TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        this.pre = dummy;
        inorder(root);
        return dummy.right;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        this.pre.right = root;
        this.pre = root;
        this.pre.left = null;
        inorder(root.right);
    }
}
