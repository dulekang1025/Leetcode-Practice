package Leetcode_1351_Count_Negative_Numbers_in_a_Sorted_Matrix;

class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            int low = 0;
            int high = grid[0].length - 1;
            int mid = 0;
            int loc = -1;
            while(low <= high){
                mid = (low + high) / 2;
                if(grid[i][mid] >= 0){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                    loc = mid;
                }
            }
            count += loc == -1 ? 0 : grid[i].length - loc;
        }
        return count;
    }
}
