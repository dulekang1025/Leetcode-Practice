package Leetcode_867_Transpose_Matrix;

class Solution {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A[0].length][A.length];
        int outter = A[0].length;
        int inner = A.length;
        for(int i = 0; i < outter; i++){
            for(int j = 0; j < inner; j++){
                res[i][j] = A[j][i];
            }
        }
        return res;
    }
}
