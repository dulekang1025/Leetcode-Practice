package Leetcode_965_Univalued_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return dfs(root, root.val);
    }
    private boolean dfs(TreeNode root, int val){
        if(root == null) return true;
        if(root.val != val) return false;
        return dfs(root.left, root.val) && dfs(root.right, root.val);
    }
}
