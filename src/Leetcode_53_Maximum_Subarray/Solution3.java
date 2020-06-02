package Leetcode_53_Maximum_Subarray;

class Solution3 {
    public int maxSubArray(int[] nums) {
        // kadane alg
        int maxTillHere = nums[0];
        int maxSoFar = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxTillHere = Math.max(nums[i], nums[i] + maxTillHere);
            maxSoFar = Math.max(maxSoFar, maxTillHere);
        }
        return maxSoFar;
    }
}
