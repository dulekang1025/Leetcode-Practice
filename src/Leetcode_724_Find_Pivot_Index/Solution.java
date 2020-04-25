package Leetcode_724_Find_Pivot_Index;

class Solution {
    public int pivotIndex(int[] nums) {
        int[] sum = new int[nums.length + 1];
        int acc = 0;
        for(int i = 0; i < nums.length; i++){
            acc += nums[i];
            sum[i+1] = acc;
        }
        for(int i = 1; i < sum.length; i++){
            if(sum[i-1] == sum[sum.length-1] - sum[i]) return i - 1;
        }
        return -1;
    }
}
