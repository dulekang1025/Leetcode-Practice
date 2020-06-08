package Leetcode_1470_Shuffle_the_Array;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int i = 0, j = n;
        int k = 0;
        while(j < 2 * n){
            if(i > (j - n)){
                ans[k++] = nums[j++];
            }else{
                ans[k++] = nums[i++];
            }
        }
        return ans;
    }
}
