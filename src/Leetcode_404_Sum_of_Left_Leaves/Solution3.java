package Leetcode_404_Sum_of_Left_Leaves;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                if(cur.left != null && cur.left.left == null && cur.left.right == null){
                    sum += cur.left.val;
                }
            }
        }
        return sum;
    }
}
