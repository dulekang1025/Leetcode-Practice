package Leetcode_463_Island_Perimeter;

class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        int hight = grid.length;
        if(hight == 0) return res;
        int width = grid[0].length;
        for(int i = 0; i < hight; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 0) continue;
                if( i == hight - 1 || grid[i+1][j] == 0) res++;
                if( i == 0 || grid[i-1][j] == 0) res++;
                if( j == width - 1 || grid[i][j+1] == 0) res++;
                if( j == 0 || grid[i][j-1] == 0) res++;
            }
        }
        return res;
    }
}
