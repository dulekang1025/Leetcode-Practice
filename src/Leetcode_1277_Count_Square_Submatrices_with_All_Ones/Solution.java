package Leetcode_1277_Count_Square_Submatrices_with_All_Ones;

class Solution {
    public int countSquares(int[][] matrix) {
        //https://www.youtube.com/watch?v=GfGsM2G1tP8
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    if(i == 0 || j == 0){
                        res++;
                        dp[i][j] = 1;
                        continue;
                    }
                    int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    dp[i][j] = min + 1;
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}
