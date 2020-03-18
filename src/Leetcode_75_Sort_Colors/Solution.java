package Leetcode_75_Sort_Colors;

class Solution {
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for(int i = 0; i <= blue; i++){
            if(nums[i] == 0){
                swap(i, red++, nums);
            }else if(nums[i] == 2){
                swap(i--, blue--, nums);
            }
        }
    }
    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
