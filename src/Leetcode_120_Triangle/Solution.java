package Leetcode_120_Triangle;

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row - 1).size();
        int[][] dp = new int[row][col];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < row; i++){
            for(int j = 0; j < triangle.get(i).size(); j++){
                if(j == triangle.get(i).size() - 1){
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                }
                else if(j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                }
                else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < col; i++){
            res = Math.min(res, dp[row - 1][i]);
        }
        return res;
    }
}
