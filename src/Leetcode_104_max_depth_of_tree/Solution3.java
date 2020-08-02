package Leetcode_104_max_depth_of_tree;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){
            ans++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
        }
        return ans;
    }
}
