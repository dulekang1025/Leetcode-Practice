package Leetcode_1493_Longest_Subarray_of_1s_After_Deleting_One_Element;

class Solution {
    public int longestSubarray(int[] nums) {
        int res = 0;
        int k = 1;
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] == 0){
                k--;
            }
            while(k < 0){
                if(nums[left] == 0){
                    k++;
                }
                left++;
            }
            res = Math.max(res, right - left);
            right++;
        }
        return res;
    }
}
