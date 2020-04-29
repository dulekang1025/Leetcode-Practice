package Leetcode_74_Search_a_2D_Matrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            int low = 0;
            int high = n - 1;
            int mid = 0;
            while(low <= high){
                mid = low + (high - low) / 2;
                if(matrix[i][mid] > target){
                    high = mid - 1;
                }else if(matrix[i][mid] < target){
                    low = mid + 1;
                }else return true;
            }
        }
        return false;
    }
}
