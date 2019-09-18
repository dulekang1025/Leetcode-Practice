package Leetcode_200_Number_of_Islands;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if(m == 0) return 0;
        int n = grid[0].length;
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1') {
                    res++;
                    dfs(i,j,grid);}
            }
        }
        return res;
    }

    public void dfs(int i, int j, char[][] grid){
        if(i<0 || j<0 || i > grid.length - 1 || j > grid[0].length - 1 || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
    }
}
