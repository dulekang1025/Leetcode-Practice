package Leetcode_530_Minimum_Absolute_Difference_in_BST;

import TreeNode.TreeNode;

public class Solution2 {
    int diff = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return 0;
        getMinimumDifference(root.left);
        if(pre != null){
            diff = Math.min(diff, Math.abs(pre.val - root.val));
        }
        pre = root;
        getMinimumDifference(root.right);
        return diff;
    }
}
