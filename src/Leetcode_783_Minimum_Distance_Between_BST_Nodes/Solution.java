package Leetcode_783_Minimum_Distance_Between_BST_Nodes;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right; int minDiffInBST
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int minDiffInBST(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        preoder(root,l);
        if(l.size()==2) return l.get(1)-l.get(0);
        else {
            int min = l.get(1) - l.get(0);
            int temp = l.get(1);
            for(int i = 2; i < l.size(); i++){
                if((l.get(i) - temp)<min) min = l.get(i) - temp;
                temp = l.get(i);
            }
            return Math.abs(min);
        }

    }
    public void preoder(TreeNode root, List<Integer> l){
        if(root.left != null) preoder(root.left, l);
        l.add(root.val);
        if(root.right != null) preoder(root.right,l);

    }
}
