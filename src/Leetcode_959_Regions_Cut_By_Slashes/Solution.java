package Leetcode_959_Regions_Cut_By_Slashes;

class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] arr = new int[n * 3][n * 3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i].charAt(j) == '\\'){
                    arr[i * 3][j * 3] = 1;
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 2][j * 3 + 2] = 1;
                }else if(grid[i].charAt(j) == '/'){
                    arr[i * 3][j * 3 + 2] = 1;
                    arr[i * 3 + 1][j * 3 + 1] = 1;
                    arr[i * 3 + 2][j * 3] = 1;
                }
            }
        }
        // for(int[] nn : arr){
        //     for(int nnn : nn)
        //         System.out.print(nnn + " ");
        //     System.out.println();
        // }
        int res = 0;
        for(int i = 0; i < 3 * n; i++){
            for(int j = 0; j < 3 * n; j++){
                if(arr[i][j] == 0){
                    dfs(arr, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    private void dfs(int[][] arr, int i, int j){
        if(i < 0 || j < 0 || i > arr.length - 1 || j > arr.length - 1 || arr[i][j] == 1) return;
        arr[i][j] = 1;
        dfs(arr, i, j + 1);
        dfs(arr, i, j - 1);
        dfs(arr, i + 1, j);
        dfs(arr, i - 1, j);
    }
}
