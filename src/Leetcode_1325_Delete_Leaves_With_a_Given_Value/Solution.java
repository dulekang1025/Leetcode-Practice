package Leetcode_1325_Delete_Leaves_With_a_Given_Value;

import TreeNode.TreeNode;

class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null) return root;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        return root.left == null && root.right == null && root.val == target
                ? null : root;
    }
}
