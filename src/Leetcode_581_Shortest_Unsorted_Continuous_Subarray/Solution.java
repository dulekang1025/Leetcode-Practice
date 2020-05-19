package Leetcode_581_Shortest_Unsorted_Continuous_Subarray;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int high = 0;
        int low = nums.length - 1;
        int len = nums.length;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[len - i -1]);
            if(nums[i] < max){
                high = i;
            }
            if(nums[len - i - 1] > min){
                low = len - i - 1;
            }
        }
        return high > low ? high - low + 1: 0;
    }
}
