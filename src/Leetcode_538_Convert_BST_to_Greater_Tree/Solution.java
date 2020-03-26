package Leetcode_538_Convert_BST_to_Greater_Tree;

import TreeNode.TreeNode;

class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return root;
        convertBST(root.right);
        root.val += this.sum;
        this.sum = root.val;
        convertBST(root.left);
        return root;
    }
}
