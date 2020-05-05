package Leetcode_39_Combination_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        for(int n : candidates) System.out.println(n);
        helper(ans, candidates, target, 0, cur);
        return ans;
    }
    private void helper(List<List<Integer>> ans, int[] candidates, int target, int i, List<Integer> cur){
        if(target == 0){
            ans.add(new ArrayList<>(cur)); //
            return;
        }
        for(int j = i; j < candidates.length; j++){
            if(target < candidates[j]) break;
            cur.add(candidates[j]);
            helper(ans, candidates, target - candidates[j], j, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
