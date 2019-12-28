package Leetcode_637_Average_of_Levels_in_Binary_Tree;

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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<Double>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        if(root == null) return res;

        queue.offer(root);

        int size = 0;
        TreeNode cur;

        while(!queue.isEmpty()){
            double temp = 0;
            size = queue.size();

            for(int i = 0; i < size; i++){
                cur = queue.pop();
                temp += cur.val;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add((double)temp/size);

        }
        return res;
    }
}
