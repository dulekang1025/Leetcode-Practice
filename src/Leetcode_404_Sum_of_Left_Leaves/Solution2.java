package Leetcode_404_Sum_of_Left_Leaves;

import TreeNode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                if(root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return sum;
    }
}
