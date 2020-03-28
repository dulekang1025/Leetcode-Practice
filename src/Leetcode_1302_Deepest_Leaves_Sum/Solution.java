package Leetcode_1302_Deepest_Leaves_Sum;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        int ans = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            res.clear();
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                res.add(cur.val);
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
        for(int i : res){
            ans += i;
        }
        return ans;
    }
}
