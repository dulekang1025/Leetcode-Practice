package Leetcode_1027_Longest_Arithmetic_Sequence;

class Solution {
    int max = 2;
    public int longestArithSeqLength(int[] A) {
        for(int i = 0; i < A.length - 1; i++){
            for(int j = i + 1; j < A.length; j++){
                int diff = A[i] - A[j];
                int len = 2;
                int temp = j;
                for(int k = j + 1; k < A.length; k++){
                    if(A[temp] - A[k] == diff){
                        len++;
                        max = Math.max(len, max);
                        temp = k;
                    }
                }
            }
        }
        return max;
    }
}
