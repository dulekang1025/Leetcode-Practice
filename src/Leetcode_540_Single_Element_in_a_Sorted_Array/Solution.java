package Leetcode_540_Single_Element_in_a_Sorted_Array;

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            mid = mid % 2 == 1 ? mid - 1 : mid;
            if(nums[mid] == nums[mid + 1]){
                low = mid + 2;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
