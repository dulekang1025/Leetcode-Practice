package Leetcode_501_Find_Mode_in_Binary_Search_Tree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] max = new int[1];
        ArrayList<Integer> mode = new ArrayList<>();
        dfs(root, map, max);
        for(int i : map.keySet()){
            if(map.get(i) == max[0]) mode.add(i);
        }
        int[] res = new int[mode.size()];
        int k = 0;
        for(int i : mode){
            res[k] = i;
            k++;
        }
        return res;
    }
    public void dfs(TreeNode root, HashMap<Integer, Integer> map, int[] max){
        if(root == null) return;
        if(!map.containsKey(root.val)) {
            map.put(root.val, 1);
            if(max[0] < 1) max[0] = 1;
        }
        else{
            int temp = map.get(root.val);
            temp++;
            map.put(root.val, temp);
            if(max[0] < temp) max[0] = temp;
        }
        dfs(root.left, map, max);
        dfs(root.right, map, max);
        return;
    }
}
