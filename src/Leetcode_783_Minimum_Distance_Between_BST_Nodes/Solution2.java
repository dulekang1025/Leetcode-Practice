package Leetcode_783_Minimum_Distance_Between_BST_Nodes;

import TreeNode.TreeNode;

public class Solution2 {
    int diff = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        if(root == null) return 0;
        minDiffInBST(root.left);
        if(pre != null){
            diff = Math.min(diff, Math.abs(pre.val - root.val));
        }
        pre = root;
        minDiffInBST(root.right);
        return diff;
    }
}
