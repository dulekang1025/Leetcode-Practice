package Leetcode_704_Binary_Search;

public class Solutioin2 {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > target){
                high = mid;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else return mid;
        }
        return -1;
    }
}
