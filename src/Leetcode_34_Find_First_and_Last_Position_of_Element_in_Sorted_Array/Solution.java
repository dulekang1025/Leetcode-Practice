package Leetcode_34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            if(nums[low] == target && nums[high] == target) return new int[]{low, high};
            if(nums[low] != target) low++;
            if(nums[high] != target) high--;
        }
        return new int[]{-1, -1};
    }
}
