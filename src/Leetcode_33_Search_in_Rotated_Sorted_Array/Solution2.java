package Leetcode_33_Search_in_Rotated_Sorted_Array;

class Solution2 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right) {
            mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            else if (nums[mid] <= nums[right]) {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }else {
                if (target < nums[mid] && target >= nums[left]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }
}
