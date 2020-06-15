package Leetcode_1480_Running_Sum_of_1d_Array;

class Solution {
    public int[] runningSum(int[] nums) {
        int[] preSum = new int[nums.length];
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            preSum[i] = sum;
        }
        return preSum;
    }
}
