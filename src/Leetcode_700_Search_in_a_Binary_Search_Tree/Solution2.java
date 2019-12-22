package Leetcode_700_Search_in_a_Binary_Search_Tree;

public class Solution2 {
    TreeNode ans;
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        else if(val > root.val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}
