package Leetcode_508_Most_Frequent_Subtree_Sum;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);
        Set<Integer> set = new HashSet<>();
        for(int k : map.keySet()){
            if(map.get(k) == maxFreq){
                set.add(k);
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for(int s : set) res[i++] = s;
        return res;
    }
    private int helper(TreeNode root){
        if(root == null) return 0;
        int sum = root.val + helper(root.left) + helper(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxFreq = maxFreq > map.get(sum) ? maxFreq : map.get(sum);
        return sum;
    }
}
