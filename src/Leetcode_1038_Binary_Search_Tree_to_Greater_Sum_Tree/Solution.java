package Leetcode_1038_Binary_Search_Tree_to_Greater_Sum_Tree;

import TreeNode.TreeNode;

class Solution {
    private int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return root;
        bstToGst(root.right);
        root.val += sum;
        sum = root.val;
        bstToGst(root.left);
        return root;
    }
}
