package Leetcode_77_Combinations;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] arr = new int[n];
        int i = 1;
        while(i <= n) {
            arr[i-1] = i;
            i++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(ans, arr, k, 0, cur);
        return ans;
    }
    private void helper(List<List<Integer>> ans, int[] arr, int k, int i, List<Integer> cur){
        if(cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return;
        }
        for(int j = i; j < arr.length; j++){
            cur.add(arr[j]);
            helper(ans, arr, k, j + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
