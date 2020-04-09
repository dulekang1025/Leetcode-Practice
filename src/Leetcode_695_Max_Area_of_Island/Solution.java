package Leetcode_695_Max_Area_of_Island;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int hight = grid.length;
        if(hight == 0) return 0;
        int width = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < hight; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1){
                    int area = dfs(i, j, grid);
                    maxArea = maxArea > area ? maxArea : area;
                }
            }
        }
        return maxArea;
    }
    private int dfs(int i,int j, int[][] grid){
        if(i < 0 || j < 0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return dfs(i, j+1, grid) + dfs(i, j-1, grid) + dfs(i-1, j, grid) + dfs(i+1, j, grid) + 1;
    }
}