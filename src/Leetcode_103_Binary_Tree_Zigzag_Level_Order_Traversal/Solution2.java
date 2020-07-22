package Leetcode_103_Binary_Tree_Zigzag_Level_Order_Traversal;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        int label = 0; // 0 : left to right; 1 : right to left
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(label == 0) {
                    list.add(node.val);
                }
                else {
                    list.add(0, node.val);
                }
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            ans.add(list);
            label = label == 1 ? 0 : 1;
        }
        return ans;
    }
}
