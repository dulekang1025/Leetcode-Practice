package Leetcode_153_Find_Minimum_in_Rotated_Sorted_Array;

class Solution2 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        return nums[low];
    }
}
