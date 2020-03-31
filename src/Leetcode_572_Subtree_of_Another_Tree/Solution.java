package Leetcode_572_Subtree_of_Another_Tree;

import TreeNode.TreeNode;

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        return isSame(s, t) || isSubtree(s.right, t) || isSubtree(s.left, t);
    }
    private boolean isSame(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
