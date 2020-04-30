package Leetcode_31_Next_Permutation;

class Solution {
    public void nextPermutation(int[] nums) {
        // first, find the fist decreasing number, start from last index
        int j = -1;
        int k = -1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                j = i;
                break;
            }
        }
        // second, go back and find the first element that is bigger than nums[i]
        for(int i = nums.length - 1; i >= 0 && j != -1; i--){
            if(nums[i] > nums[j]){
                k = i;
                break;
            }
        }
        // third, swap j k
        if(j != -1 && k != -1){
            int temp = nums[j];
            nums[j] = nums[k];
            nums[k] = temp;
        }
        // finally, reverse the sub-array[j, nums.length - 1];
        if(j != -1){
            int l = nums.length - 1;
            j += 1;
            while(j < l){
                int temp = nums[j];
                nums[j] = nums[l];
                nums[l] = temp;
                j++;
                l--;
            }
        }else{
            int l = nums.length - 1;
            j = 0;
            while(j < l){
                int temp = nums[j];
                nums[j] = nums[l];
                nums[l] = temp;
                j++;
                l--;
            }
        }
    }
}