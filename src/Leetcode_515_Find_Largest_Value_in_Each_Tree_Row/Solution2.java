package Leetcode_515_Find_Largest_Value_in_Each_Tree_Row;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                max = cur.val > max ? cur.val : max;
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
