package Leetcode_951_Flip_Equivalent_Binary_Trees;

import TreeNode.TreeNode;

class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }
    private boolean dfs(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        if((root1.left != null && root2.left == null) || (root1.left == null && root2.left != null)
                || root1.left != null && root2.left != null && (root1.left.val != root2.left.val)){
            TreeNode temp = root1.right;
            root1.right = root1.left;
            root1.left = temp;
        }
        boolean left = dfs(root1.left, root2.left);
        boolean right = dfs(root1.right, root2.right);
        return left && right;
    }
}
