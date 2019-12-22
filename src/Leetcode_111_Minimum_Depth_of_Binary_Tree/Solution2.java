package Leetcode_111_Minimum_Depth_of_Binary_Tree;

import TreeNode.TreeNode;

public class Solution2 {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        else{
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
    }
}
