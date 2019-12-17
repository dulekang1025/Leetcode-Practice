package Leetocde_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        TreeNode ans = null;
        if(p.val == root.val || q.val == root.val) return root;
        if(p.val < root.val && q.val < root.val) ans = lowestCommonAncestor(root.left,p,q);
        if(p.val > root.val && q.val > root.val) ans = lowestCommonAncestor(root.right,p,q);
        if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) return root;
        return ans;
    }
}