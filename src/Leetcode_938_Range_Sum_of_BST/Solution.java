package Leetcode_938_Range_Sum_of_BST;

import TreeNode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        if(root == null) return sum;
        if(root.val >= L && root.val <= R) sum += root.val;
        if(root.left != null) sum += rangeSumBST(root.left, L, R);
        if(root.right != null) sum += rangeSumBST(root.right, L, R);
        return sum;
    }
}
