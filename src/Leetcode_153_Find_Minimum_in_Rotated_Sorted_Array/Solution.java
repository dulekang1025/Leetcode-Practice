package Leetcode_153_Find_Minimum_in_Rotated_Sorted_Array;

class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    private int helper(int[] nums, int l, int r){
        if(l + 1 >= r) return Math.min(nums[l], nums[r]);
        if(nums[l] < nums[r]) return nums[l];
        int mid = (l + r) / 2;
        return Math.min(helper(nums, l, mid - 1), helper(nums, mid, r));
    }
}
