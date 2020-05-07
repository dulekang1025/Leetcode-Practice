package Leetcode_80_Remove_Duplicates_from_Sorted_Array_II;

class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; // next index to be replaced
        for(int n : nums){
            if(k < 2 || nums[k - 2] < n){
                nums[k++] = n;
            }
        }
        return k;
    }
}
