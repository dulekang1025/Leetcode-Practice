package Leetcode_662_Maximum_Width_of_Binary_Tree;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indices = new LinkedList<>();
        queue.add(root);
        indices.add(1);
        int max = 1;
        int left = 0, right = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                int index = indices.poll();
                if(i == 0) left = index;
                if(i == size - 1) right = index;
                if(cur.left != null){
                    queue.offer(cur.left);
                    indices.offer(index * 2);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    indices.offer(index * 2 + 1);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}