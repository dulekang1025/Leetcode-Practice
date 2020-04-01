package Leetcode_958_Check_Completeness_of_a_Binary_Tree;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean miss = false;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                if(cur != null){
                    if(miss) return false;
                    q.offer(cur.left);
                    q.offer(cur.right);
                }else{
                    miss = true;
                }
            }
        }
        return true;
    }
}
