package Leetcode_416_Partition_Equal_Subset_Sum;

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        Arrays.sort(nums);
        return dfs(nums, target, nums.length - 1);
    }
    private boolean dfs(int[] nums, int target, int pos){
        if(target < 0 || pos < 0) return false;
        target -= nums[pos];
        if(target == 0) return true;
        pos--;
        for(int i = pos; i >= 0; i--){
            if(dfs(nums, target, i)) return true;
        }
        return false;
    }
}
