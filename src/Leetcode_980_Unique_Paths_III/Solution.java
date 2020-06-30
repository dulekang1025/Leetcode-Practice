package Leetcode_980_Unique_Paths_III;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int res = 0;
    List<int[]> arr = new ArrayList<>();
    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int[] start = new int[2];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //if(grid[i][j] == -1 || grid[i][j] == 2) continue;
                if(grid[i][j] == 1){
                    start[0] = i;
                    start[1] = j;
                    count++;
                }
                if(grid[i][j] == 0){
                    count++;
                }
            }
        }
        dfs(grid, start[0], start[1], count);
        return res;
    }
    private void dfs(int[][] grid, int i, int j, int count){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == -1) return;
        if(count != 0 && grid[i][j] == 2) return;
        if(count == 0 && grid[i][j] == 2){
            res++;
            return;
        }
        int cur = grid[i][j];
        grid[i][j] = -1;
        dfs(grid, i + 1, j, count - 1);
        dfs(grid, i - 1, j, count - 1);
        dfs(grid, i, j + 1, count - 1);
        dfs(grid, i, j - 1, count - 1);
        grid[i][j] = cur;
    }
}
