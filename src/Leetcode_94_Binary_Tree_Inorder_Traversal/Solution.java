package Leetcode_94_Binary_Tree_Inorder_Traversal;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur != null || !s.isEmpty()){
            while(cur != null){
                s.push(cur);
                cur = cur.left;
            }
            cur = s.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}
