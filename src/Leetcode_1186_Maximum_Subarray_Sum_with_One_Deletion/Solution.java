package Leetcode_1186_Maximum_Subarray_Sum_with_One_Deletion;

class Solution {
    public int maximumSum(int[] arr) {
        if(arr.length == 1)return arr[0];
        int len = arr.length;
        int max = Integer.MIN_VALUE;;
        int[] dpPre = new int[len];
        int[] dpPost = new int[len];
        dpPre[0] = arr[0];
        dpPost[len - 1] = arr[len - 1];
        for(int i = 1; i < len; i++){
            dpPre[i] = Math.max(dpPre[i - 1] + arr[i], arr[i]);
            dpPost[len - 1 - i] = Math.max(dpPost[len - i] + arr[len - i - 1], arr[len - i - 1]);
            max = Math.max(max, Math.max(dpPre[i], dpPost[len - 1 - i]));
        }
        for(int i = 0; i < len; i++){
            int left = i == 0 ? 0 : dpPre[i - 1];
            int right = i == len - 1 ? 0 : dpPost[i + 1];
            max = Math.max(max, left + right);
        }
        return max;
    }
}
