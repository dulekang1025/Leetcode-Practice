package Leetcode_104_max_depth_of_tree;

import TreeNode.TreeNode;

public class Solution2 {
    public int maxDepth(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode root, int d){
        if(root == null) return d;
        int l = helper(root.left, d + 1);
        int r = helper(root.right, d + 1);
        return (l > r) ? l : r;
    }
}
