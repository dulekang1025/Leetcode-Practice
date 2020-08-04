package Leetcode_199_Binary_Tree_Right_Side_View;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int val = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                val = cur.val;
            }
            ans.add(val);
        }
        return ans;
    }
}
