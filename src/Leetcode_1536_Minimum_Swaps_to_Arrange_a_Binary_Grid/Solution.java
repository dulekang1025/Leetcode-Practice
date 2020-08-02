package Leetcode_1536_Minimum_Swaps_to_Arrange_a_Binary_Grid;

class Solution {
    public int minSwaps(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] g = new int[m];
        // g[i] <= i;
        for(int i = 0; i < m; i++){
            for(int j = n - 1; j >= 0; j--){
                if(grid[i][j] == 1){
                    g[i] = j;
                    break;
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < m; i++){
            if(g[i] <= i) continue;
            int pos = -1;
            for(int j = i + 1; j < n; j++){
                if(g[j] <= i){
                    pos = j;
                    break;
                }
            }
            if(pos == -1) return -1;
            for(int j = pos; j > i; j--){
                int temp = g[j];
                g[j] = g[j - 1];
                g[j - 1] = temp;
            }
            ans += (pos - i);
        }
        return ans;
    }
}
