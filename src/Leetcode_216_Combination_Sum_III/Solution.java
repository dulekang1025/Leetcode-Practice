package Leetcode_216_Combination_Sum_III;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(ans, arr, k, n, 0, cur);
        return ans;
    }
    private void helper(List<List<Integer>> ans, int[] arr, int k, int target, int i, List<Integer> cur){
        if(cur.size() > k || target < 0) return;
        if(cur.size() == k && target == 0){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int j = i; j < arr.length; j++){
            cur.add(arr[j]);
            helper(ans, arr, k, target - arr[j], j + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
