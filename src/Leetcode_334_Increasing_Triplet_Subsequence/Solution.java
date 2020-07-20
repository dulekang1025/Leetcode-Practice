package Leetcode_334_Increasing_Triplet_Subsequence;

import java.util.Arrays;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                if(dp[i] >= 3) return true;
            }
        }
        return false;
    }
}
