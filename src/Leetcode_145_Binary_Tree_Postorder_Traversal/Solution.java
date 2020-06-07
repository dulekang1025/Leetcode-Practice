package Leetcode_145_Binary_Tree_Postorder_Traversal;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        TreeNode lastVisited = root;
        while(!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if(root.right == null || root.right == lastVisited){
                ans.add(root.val);
                lastVisited = stack.pop();
                root = null;
            }else{
                root = root.right;
            }
        }
        return ans;
    }
}
