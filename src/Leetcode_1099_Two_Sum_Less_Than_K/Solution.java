package Leetcode_1099_Two_Sum_Less_Than_K;

import java.util.Arrays;

class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        int ans = -1;
        Arrays.sort(A);
        int lo = 0, hi = A.length - 1;
        while(lo < hi){
            int currSum = A[lo] + A[hi];
            if(currSum < K){
                ans = Math.max(ans, currSum);
                lo++;
            }else{
                hi--;
            }
        }
        return ans;
    }
}
