package Leetcode_55_Jump_Game;

class Solution {
    public boolean canJump(int[] nums) {
        for(int i=0;i<nums.length - 1;i++){
            if(nums[i] <= 0){
                boolean flag = false;
                for(int j = i; j >=0; j--){
                    if(nums[j] >= i - j + 1)
                        flag = true;
                }
                if(flag == false) return false;
            }
        }
        return true;
    }
}
