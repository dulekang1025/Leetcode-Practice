package Leetcode_674_Longest_Continuous_Increasing_Subsequence;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0) return 0;
        int maxTillHere = 1;
        int max = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]) maxTillHere++;
            else maxTillHere = 1;
            max = Math.max(max, maxTillHere);
        }
        return max;
    }
}
