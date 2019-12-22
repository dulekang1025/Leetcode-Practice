package Leetcode_700_Search_in_a_Binary_Search_Tree;

import TreeNode.TreeNode;

class Solution {
    TreeNode ans;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(ans == null) ans = searchBST(root.left,val);
        if(ans == null) ans = searchBST(root.right,val);
        return ans;
    }
}
