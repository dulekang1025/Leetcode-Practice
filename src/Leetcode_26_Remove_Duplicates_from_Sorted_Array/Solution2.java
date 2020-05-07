package Leetcode_26_Remove_Duplicates_from_Sorted_Array;

class Solution2 {
    public int removeDuplicates(int[] nums) {
        int prev = 0; int fast = 0;
        while(fast < nums.length){
            if(nums[prev] == nums[fast]) fast++;
            else{
                nums[++prev] = nums[fast++];
            }
        }
        return prev + 1;
    }
}
