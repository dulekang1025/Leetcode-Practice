package Leetcode_63_Unique_Paths_II;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;  //col
        int m = obstacleGrid.length;
        int[][] dp = new int[m + 1][n + 1]; //[row][col]
        dp[1][1] = 1;
        for(int i = 1; i < m + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(i == 1 && j == 1){
                    if(obstacleGrid[0][0] == 1) dp[1][1] = 0;
                    continue;
                }
                if(obstacleGrid[i - 1][j - 1] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}