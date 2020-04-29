package Leetcode_240_Search_a_2D_Matrix_II;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int x = m - 1;
        int y = 0;
        while(true){
            if(matrix[x][y] > target) x--;
            else if(matrix[x][y] < target) y++;
            else return true;
            if(x < 0 || y > n - 1) break;
        }
        return false;
    }
}
