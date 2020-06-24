package Leetcode_74_Search_a_2D_Matrix;

class Solution3 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        // search the first col, find target row.
        int low = 0;
        int high = m;
        int mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(matrix[mid][0] == target) return true;
            else if(matrix[mid][0] > target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        int row = low == 0 ? low : low - 1;
        high = n;
        low = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(matrix[row][mid] == target) return true;
            else if(matrix[row][mid] > target){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }
}
