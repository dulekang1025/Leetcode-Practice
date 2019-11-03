package Leetcode_103_Binary_Tree_Zigzag_Level_Order_Traversal;

import TreeNode.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null) return res;
        queue.offer(root);
        int size = 0;
        while(!queue.isEmpty()){

            List<Integer> l = new LinkedList<Integer>();
            size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curNode = queue.pop();
                l.add(curNode.val);
                if(curNode.left != null) queue.offer(curNode.left);
                if(curNode.right != null) queue.offer(curNode.right);
            }
            res.add(l);
        }
        int flag = 0;
        for(List i : res){
            if(flag == 0){
                flag = 1;
                continue;
            }
            if(flag == 1){
                flag = 0;
                Collections.reverse(i);
            }
        }
        return res;
    }
}
