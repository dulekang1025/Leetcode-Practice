package Leetcode_623_Add_One_Row_to_Tree;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1){
            TreeNode new_root = new TreeNode(v);
            new_root.left = root;
            return new_root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            level++;
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                TreeNode tempLeft = cur.left;
                TreeNode tempRight = cur.right;
                if(level + 1 == d){
                    cur.left = new TreeNode(v);
                    cur.right = new TreeNode(v);
                    cur.left.left = tempLeft;
                    cur.right.right = tempRight;
                }
                if(tempLeft != null) q.offer(tempLeft);
                if(tempRight != null) q.offer(tempRight);
            }
        }
        return root;
    }
}