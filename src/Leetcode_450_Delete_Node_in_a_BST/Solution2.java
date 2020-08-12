package Leetcode_450_Delete_Node_in_a_BST;

import TreeNode.TreeNode;

public class Solution2 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                root = null;
            }
            else if(root.left == null && root.right != null){
                root = root.right;
            }
            else if(root.left != null && root.right == null){
                root = root.left;
            }
            else if(root.left != null && root.right != null){
                TreeNode t = root.right;
                while(t.left != null){
                    t = t.left;
                }
                t.left = root.left;
                root = root.right;
            }
        }
        return root;
    }
}
