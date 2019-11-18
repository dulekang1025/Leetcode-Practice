package Leetcode_102_Binary_Tree_Level_Order_Traversal;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        int size = 0;
        while(!queue.isEmpty()){

            List<Integer> l = new LinkedList<Integer>();
            size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curNode = queue.pop();
                l.add(curNode.val);
                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);
            }
            res.add(l);
        }
        return res;
    }
}