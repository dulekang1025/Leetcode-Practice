package Leetcode_1504_Count_Submatrices_With_All_Ones;

class Solution {
    public int numSubmat(int[][] mat) {
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            int width = 0;
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 1){
                    width++;
                }else{
                    width = 0;
                }
                dp[i][j] = width;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int min = Integer.MAX_VALUE;
                for(int k = i; k >= 0; k--){
                    min = Math.min(min, dp[k][j]);
                    if(min == 0) break;
                    ans += min;
                }
            }
        }
        return ans;
    }
}
