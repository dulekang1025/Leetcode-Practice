package Leetcode_1437_CheckIfAll1sAtLeastLengthKPlacesAway;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        for(int i = 0; i < nums.length;){
            if(nums[i] == 1){
                int d = 0;
                i++;
                while(i < nums.length && nums[i] == 0){
                    d++;
                    i++;
                }
                if(d < k && i < nums.length){
                    return false;
                }
            }else{
                i++;
            }
        }
        return true;
    }
}
