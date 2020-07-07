package Leetcode_463_Island_Perimeter;

class Solution2 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    int neis = check(grid, i, j);
                    if(neis == 0) count += 4;
                    if(neis == 1) count += 3;
                    if(neis == 2) count += 2;
                    if(neis == 3) count += 1;
                }
            }
        }
        return count;
    }
    private int check(int[][] grid, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        if(i - 1 >= 0 && grid[i - 1][j] == 1) res++;
        if(i + 1 < m && grid[i + 1][j] == 1) res++;
        if(j - 1 >= 0 && grid[i][j - 1] == 1) res++;
        if(j + 1 < n && grid[i][j + 1] == 1) res++;
        return res;
    }
}
