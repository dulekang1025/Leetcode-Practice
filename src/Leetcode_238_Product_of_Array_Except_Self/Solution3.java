package Leetcode_238_Product_of_Array_Except_Self;

class Solution3 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] pre = new int[len];
        int[] post = new int[len];
        int[] ans = new int[len];
        pre[0] = nums[0];
        post[len - 1] = nums[len - 1];
        for(int i = 1; i < len; i++){
            pre[i] = pre[i - 1] * nums[i];
            post[len - 1 - i] = post[len - i] * nums[len - 1 - i];
        }
        for(int n : pre) System.out.print(n + " ");
        System.out.println();
        for(int n : post) System.out.print(n + " ");
        for(int i = 0; i < len; i++){
            int left = i == 0 ? 1 : pre[i - 1];
            int right = i == len - 1 ? 1 : post[i + 1];
            ans[i] = left * right;
        }
        return ans;
    }
}
