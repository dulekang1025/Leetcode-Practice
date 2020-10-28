package Leetcode_545_Boundary_of_Binary_Tree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<TreeNode> left = new ArrayList<>();
    List<TreeNode> right = new ArrayList<>();
    List<TreeNode> leaf = new ArrayList<>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null) left.add(root);
        if(root.right == null) right.add(root);
        if(root.left != null) findLeft(root);
        if(root.right != null) findRight(root);
        findLeaf(root);
        // for(TreeNode node : left){
        //     System.out.print(node.val + " ");
        // }
        // System.out.println();
        // for(TreeNode node : right){
        //     System.out.print(node.val + " ");
        // }
        // System.out.println();
        // for(TreeNode node : leaf){
        //     System.out.print(node.val + " ");
        // }
        return reOrder();
    }

    private void findLeft(TreeNode root){
        if(root == null) return;
        left.add(root);
        if(root.left != null) findLeft(root.left);
        else if(root.left == null && root.right != null) findLeft(root.right);
    }

    private void findRight(TreeNode root){
        if(root == null) return;
        right.add(root);
        if(root.right != null) findRight(root.right);
        else if(root.right == null && root.left != null) findRight(root.left);
    }

    private void findLeaf(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            leaf.add(root);
        }
        findLeaf(root.left);
        findLeaf(root.right);
    }

    private List<Integer> reOrder(){
        Set<TreeNode> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for(TreeNode node : left){
            set.add(node);
            ans.add(node.val);
        }
        for(TreeNode node : leaf){
            if(set.contains(node)) continue;
            set.add(node);
            ans.add(node.val);
        }
        for(int i = right.size() - 1; i >= 0; i--){
            TreeNode node = right.get(i);
            if(set.contains(node)) continue;
            set.add(node);
            ans.add(node.val);
        }
        return ans;
    }
}
