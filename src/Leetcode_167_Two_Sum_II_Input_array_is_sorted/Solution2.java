package Leetcode_167_Two_Sum_II_Input_array_is_sorted;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while(low < high){
            int sum = nums[low] + nums[high];
            if(sum > target){
                high--;
            }else if(sum < target){
                low++;
            }else{
                return new int[]{low + 1, high + 1};
            }
        }
        return new int[]{};
    }
}
