package Leetcode_239_Sliding_Window_Maximum;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int[] ans = new int[len - k + 1];
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int i = 0;
        while(right < len){
            while(right - left < k){
                max = Math.max(max, nums[right]);
                right++;
            }
            ans[i] = max;
            i++;
            if(right - left == k){
                left++;
                max = Integer.MIN_VALUE;
                for(int j = left; j < right; j++){
                    max = Math.max(max, nums[j]);
                }
            }
        }
        return ans;
    }
}
