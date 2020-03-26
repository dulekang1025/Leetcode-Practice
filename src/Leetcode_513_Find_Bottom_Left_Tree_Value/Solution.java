package Leetcode_513_Find_Bottom_Left_Tree_Value;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            res = q.peek().val;
            TreeNode cur = null;
            for(int i = 0; i < n; i++){
                cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
        return res;
    }
}
