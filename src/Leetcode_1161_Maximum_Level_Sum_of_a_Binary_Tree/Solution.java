package Leetcode_1161_Maximum_Level_Sum_of_a_Binary_Tree;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxSum = Integer.MIN_VALUE;
        int minlevel = 0;
        int level = 0;
        while(!queue.isEmpty()){
            int sum = 0;
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            if(sum > maxSum){
                maxSum = sum;
                minlevel = level;
            }
        }
        return minlevel;
    }
}