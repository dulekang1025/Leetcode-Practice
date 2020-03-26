package Leetcode_513_Find_Bottom_Left_Tree_Value;

import TreeNode.TreeNode;

class Solution2 {
    int res = 0;
    int maxDepth = -1;
    public int findBottomLeftValue(TreeNode root) {
        helper(root, 0);
        return res;
    }
    public void helper(TreeNode node, int depth){
        if(node == null) return;
        if(depth > maxDepth){
            res = node.val;
            System.out.println(maxDepth+" "+ depth+" "+ res);
            maxDepth = depth;
        }
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }
}
