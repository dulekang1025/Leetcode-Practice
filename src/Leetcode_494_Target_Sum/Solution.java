package Leetcode_494_Target_Sum;

class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calc(nums, S, 0, 0);
        return res;
    }
    private void calc(int[] nums, int target, int sum, int i){
        if(i == nums.length){
            if(sum == target){
                res++;
                return;
            }
        }else{
            calc(nums, target, sum + nums[i], i + 1);
            calc(nums, target, sum - nums[i], i + 1);
        }
    }
}