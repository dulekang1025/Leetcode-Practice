package Leetcode_814_Binary_Tree_Pruning;

import TreeNode.TreeNode;

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if(!hasOne(root)){
            root = null;
            return root;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        return root;
    }
    private boolean hasOne(TreeNode root){
        if(root == null) return false;
        if(root.val == 1) return true;
        return hasOne(root.left) || hasOne(root.right);
    }
}
