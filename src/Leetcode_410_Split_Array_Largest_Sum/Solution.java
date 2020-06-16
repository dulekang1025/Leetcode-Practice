package Leetcode_410_Split_Array_Largest_Sum;

class Solution {
    public int splitArray(int[] nums, int m) {
        int low = 0, high = 0, mid = 0;
        for(int n : nums){
            low = Math.max(low, n);
            high += n;
        }
        while(low < high){
            mid = low + (high - low) / 2;
            int arrNum = split(nums, mid);
            if(arrNum > m)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    private int split(int[] nums, int mid){
        int temp = 0;
        int count = 1;
        for(int n : nums){
            temp += n;
            if(temp > mid){
                count++;
                temp = n;
            }
        }
        return count;
    }
}
