package Leetcode_324_Wiggle_Sort_II;

import java.util.Arrays;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int mid = (nums.length % 2) == 1 ? nums.length/2 : nums.length/2 - 1;
        int r = mid;
        int l = nums.length - 1;
        int cur = 0;
        while(r >= 0 || l > mid){
            if(r >= 0) nums[cur++] = arr[r--];
            if(l > mid) nums[cur++] = arr[l--];
        }
    }
}
