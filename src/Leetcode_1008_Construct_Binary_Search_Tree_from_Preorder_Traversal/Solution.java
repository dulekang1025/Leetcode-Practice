package Leetcode_1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import TreeNode.TreeNode;

class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i = 0; i < preorder.length; i++){
            root = helper(root, preorder[i]);
        }
        return root;
    }
    private TreeNode helper(TreeNode root, int val){
        if(root == null) return new TreeNode(val);
        if(val < root.val){
            root.left = helper(root.left, val);
        }else{
            root.right = helper(root.right, val);
        }
        return root;
    }
}
