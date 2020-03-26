package Leetcode_515_Find_Largest_Value_in_Each_Tree_Row;

import TreeNode.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> l = new ArrayList();
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                l.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            Collections.sort(l);
            res.add(l.get(l.size()-1));
        }
        return res;
    }
}
