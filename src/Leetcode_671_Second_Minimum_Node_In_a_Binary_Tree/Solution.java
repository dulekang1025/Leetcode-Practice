package Leetcode_671_Second_Minimum_Node_In_a_Binary_Tree;

import TreeNode.TreeNode;

import java.util.LinkedList;

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        Integer secondMin = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int size = 0;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                if(cur.val != root.val){
                    if(secondMin == null) secondMin = cur.val;
                    else secondMin = Math.min(secondMin, cur.val);
                }
            }
        }
        return secondMin==null? -1 : secondMin;
    }
}
