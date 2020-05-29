package Leetcode_41_First_Missing_Positive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]){
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                ans = i + 1;
                break;
            }
        }
        return ans == 0 ? nums.length + 1 : ans;
    }
}
