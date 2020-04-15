package Leetcode_238_Product_of_Array_Except_Self;

class Solution2 {
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int n = nums.length;
        int[] ans = new int[n];
        int[] fw = new int[n];
        int[] bw = new int[n];
        fw[0] = 1;
        bw[n-1] = 1;
        for(int i = 1; i < n; i++){
            fw[i] = fw[i-1] * nums[i-1];
        }
        for(int i = n - 2; i >= 0; i--){
            bw[i] = bw[i+1] * nums[i+1];
        }
        for(int i = 0; i < n; i++){
            ans[i] = fw[i] * bw[i];
        }
        return ans;
    }
}
