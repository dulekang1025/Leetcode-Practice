package Leetcode_566_Reshape_the_Matrix;

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if(n * m < r * c || n * m > r * c) return nums;
        int[][] ans = new int[r][c];
        int rr = 0, cc = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                ans[rr][cc] = nums[i][j];
                cc++;
                if(cc == c){
                    rr++;
                    cc = 0;
                }
            }
        }
        return ans;
    }
}
