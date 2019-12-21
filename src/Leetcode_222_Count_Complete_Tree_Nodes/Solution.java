package Leetcode_222_Count_Complete_Tree_Nodes;

import TreeNode.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.right == null && root.left == null) return 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
