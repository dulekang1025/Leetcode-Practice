package Leetcode_1004_Max_Consecutive_Ones_III;

class Solution {
    public int longestOnes(int[] A, int K) {
        int res = 0;
        int left = 0, right = 0;
        while(right < A.length){
            if(A[right] == 0){
                K--;
            }
            while(K < 0){
                if(A[left] == 0){
                    K++;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
