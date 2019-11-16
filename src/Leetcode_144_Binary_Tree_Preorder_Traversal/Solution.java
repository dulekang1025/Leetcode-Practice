package Leetcode_144_Binary_Tree_Preorder_Traversal;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){
            while(cur != null){
                result.add(cur.val);
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop().right;
        }
        return result;
    }
}