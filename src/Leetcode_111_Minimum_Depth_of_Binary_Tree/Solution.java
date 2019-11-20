package Leetcode_111_Minimum_Depth_of_Binary_Tree;

import TreeNode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        return (r == 0 || l == 0)? r + l + 1 :Math.min(l,r) + 1;
    }
}