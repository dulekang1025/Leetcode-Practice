package Leetcode_104_max_depth_of_tree;

import TreeNode.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = depth(root,0);
        int right = depth(root,0);

        return Math.max(left,right);
    }

    public int depth(TreeNode node, int d){
        if(node == null) return d;
        int left = depth(node.left,d + 1);
        int right = depth(node.right, d + 1);

        return Math.max(left,right);
    }
}
