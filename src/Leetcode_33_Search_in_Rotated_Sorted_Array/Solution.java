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


//class Solution {
//    public int search(int[] nums, int target) {
//        if(nums.length <= 0) return -1;
//        int low = 0, high = nums.length - 1, mid = 0;
//        while(low < high){
//            mid = low + (high - low) / 2;
//            if(nums[mid] > nums[high]) low = mid + 1;
//            else high = mid;
//        }
//        System.out.println(low);
//        int pivot = low;
//        if(nums[pivot] <= target && target <= nums[nums.length - 1]) high = nums.length;
//        else {
//            low = 0;
//            high = pivot;
//        }
//        System.out.println(low + " " + high);
//        while(low < high){
//            mid = low + (high - low) / 2;
//            if(nums[mid] >= target) high = mid;
//            else low = mid + 1;
//        }
//        return low == nums.length || nums[low] != target  ? -1 : low;
//    }
//}

// [4,5,6,7,0,1,2]
// 0
// [4,5,6,7,8,0,1,2,3]
// 3
// [4,5,6,7,0,1,2]
// 3
// [1]
// 0
// [3,1]
// 3