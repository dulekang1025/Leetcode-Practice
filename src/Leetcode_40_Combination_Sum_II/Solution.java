package Leetcode_40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        helper(ans, candidates, target, 0, cur);
        return ans;
    }
    private void helper(List<List<Integer>> ans, int[] candidates, int target, int i, List<Integer> cur){
        if(target < 0) return;
        if(target == 0 && !ans.contains(cur)){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(; i < candidates.length; i++){
            cur.add(candidates[i]);
            helper(ans, candidates, target - candidates[i], i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
