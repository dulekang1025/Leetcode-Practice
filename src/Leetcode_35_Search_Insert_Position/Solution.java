package Leetcode_35_Search_Insert_Position;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i<nums.length && nums[i] < target){
            i++;
        }
        return i;
    }
}
