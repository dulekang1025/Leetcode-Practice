package Leetcode_74_Search_a_2D_Matrix;

class Solution2 {
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
            if(matrix[mid][0] > target){
                high = mid;
            }else if(matrix[mid][0] < target){
                low = mid + 1;
            }else return true;
        }
        // low - 1 (or low if low == 0) is the target row,  search on this row
        int r = low == 0 ? low : low - 1;
        low = 0;
        high = n - 1;
        mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(matrix[r][mid] > target){
                high = mid - 1;
            }else if(matrix[r][mid] < target){
                low = mid + 1;
            }else return true;
        }
        return false;
    }
}
