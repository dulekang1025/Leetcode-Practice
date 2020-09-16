package Leetcode_1214_Two_Sum_BSTs;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1 == null || root2 == null) return false;
        helper(root1);
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root2 != null){
            while(root2 != null){
                stack.push(root2);
                root2 = root2.left;
            }
            root2 = stack.pop();
            if(set.contains(target - root2.val)) return true;
            root2 = root2.right;
        }
        return false;
    }
    private void helper(TreeNode root){
        if(root == null) return;
        set.add(root.val);
        helper(root.left);
        helper(root.right);
    }
}
