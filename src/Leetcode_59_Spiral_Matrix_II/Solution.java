package Leetcode_59_Spiral_Matrix_II;

class Solution {
    public int[][] generateMatrix(int n) {

        // upper ---- right
        //   |          |
        //   |          |
        // left  ----  down

        int[][] mat = new int[n][n];
        int upper = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int k = 1;
        while(upper <= down && left <= right && k <= n * n){
            for(int c = left; c <= right && k <= n * n; c++) mat[upper][c] = k++;
            for(int r = upper + 1; r <= down && k <= n * n; r++) mat[r][right] = k++;
            if(upper < down && left < right && k <= n * n){
                for(int c = right - 1; c >= left  && k <= n * n; c--) mat[down][c] = k++;
                for(int r = down - 1; r > upper  && k <= n * n; r--) mat[r][left] = k++;
            }
            upper++;
            down--;
            left++;
            right--;
        }
        return mat;
    }
}
