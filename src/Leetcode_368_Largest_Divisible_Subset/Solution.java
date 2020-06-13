package Leetcode_368_Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums.length == 0) return ans;
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] == dp[j] + 1){
                        prev[i] = j;
                    }
                }
            }
        }
        int pos = 0;
        int max = dp[0];
        for(int i = 0; i < n; i++){
            if(dp[i] > max){
                max = dp[i];
                pos = i;
            }
        }
        while(pos != -1){
            ans.add(nums[pos]);
            pos = prev[pos];
        }
        return ans;
    }
}
