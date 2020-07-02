package Leetcode_238_Product_of_Array_Except_Self;

class Solution4 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] post = new int[len];
        int right = 1;
        post[len - 1] = nums[len - 1];
        for(int i = 1; i < len; i++){
            post[len - 1 - i] = post[len - i] * nums[len - 1 - i];
        }
        for(int i = 0; i < len - 1; i++){
            post[i] = post[i + 1] * right;
            right *= nums[i];
        }
        post[len - 1] = right;
        return post;
    }
}
