package Leetcode_33_Search_in_Rotated_Sorted_Array;

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length <= 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]) low = mid + 1;
            else high = mid;
        }
        System.out.println(low);
        // pivot point is at low, also is the smallest point
        // find out search range, before of after the pivot point
        int pp = low;
        low = 0;
        high = nums.length - 1;
        mid = 0;
        if(target >= nums[pp] && target <= nums[high]){
            low = pp;
        }else{
            high = pp;
        }
        System.out.println(low + " " + high);
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] > target) high = mid - 1;
            else if(nums[mid] < target) low = mid + 1;
            else return mid;
        }
        return -1;
    }
}
