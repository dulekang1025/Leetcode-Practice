package Leetcode_1609_Even_Odd_Tree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        //For every even-indexed level,
        // all nodes at the level have odd integer values in strictly increasing order (from left to right).
        //For every odd-indexed level,
        // all nodes at the level have even integer values in strictly decreasing order (from left to right).
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        boolean odd = true;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            odd = odd ? false : true; // true : odd, false : even
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            if(odd){
                // all nodes at the level have even integer values in strictly decreasing order
                Integer prev = null;
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i) % 2 != 0) return false;
                    if(prev == null){
                        prev = list.get(i);
                    }else{
                        if(prev <= list.get(i)) return false;
                        prev = list.get(i);
                    }
                }
            }else{
                // all nodes at the level have odd integer values in strictly increasing order
                Integer prev = null;
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i) % 2 == 0) return false;
                    if(prev == null){
                        prev = list.get(i);
                    }else{
                        if(prev >= list.get(i)) return false;
                        prev = list.get(i);
                    }
                }
            }
        }
        return true;
    }
}












