package Leetcode_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree;

import TreeNode.TreeNode;

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // Do dfs to both tree at the same time
        if(original == null) return null;
        if(original == target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return left != null ? left : right;
    }
}
