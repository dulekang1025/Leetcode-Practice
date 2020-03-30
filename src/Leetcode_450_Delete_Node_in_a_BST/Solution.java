package Leetcode_450_Delete_Node_in_a_BST;

import TreeNode.TreeNode;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            TreeNode new_root = null;
            if(root.right == null){
                return root.left;
            }
            else if(root.left == null){
                return root.right;
            }
            else{
                // find the smallest node in the right subtree,
                // and set it as new root;
                new_root = root.right;
                while(new_root.left != null){
                    new_root = new_root.left;
                }
                root.val = new_root.val;
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }
}
