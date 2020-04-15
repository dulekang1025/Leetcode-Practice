package Leetcode_238_Product_of_Array_Except_Self;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int product = 1;
        boolean hasOneZero = false;
        boolean hasMoreZero = false;
        int zeroCounter = 0;
        for(int i : nums){
            if(i == 0) {
                hasOneZero = true;
                zeroCounter++;
                if(zeroCounter > 1){
                    hasMoreZero = true;
                    return ans;
                }
                continue;
            }
            product *= i;
        }
        if(hasOneZero){
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0) ans[i] = product;
                else nums[i] = 0;
            }
        }else{
            for(int i = 0; i < nums.length; i++){
                ans[i] = product/nums[i];
            }
        }

        return ans;
    }
}
