package Leetcode_994_Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    int total = 0;
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean hasOne = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) queue.offer(new int[]{i, j});
                if(grid[i][j] == 1) {
                    total++;
                }
            }
        }
        int ans = 0;
        if(total == 0) return ans;
        while(!queue.isEmpty()){
            ans++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                check(grid, queue, cur[0], cur[1]);
            }
        }
        return total == 0 ? ans - 1 : -1;
    }
    private void check(int[][] grid, Queue<int[]> queue, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(i > 0 && grid[i - 1][j] == 1){
            queue.offer(new int[]{i - 1, j});
            total--;
            grid[i - 1][j] = 2;
        }
        if(i < m - 1 && grid[i + 1][j] == 1){
            queue.offer(new int[]{i + 1, j});
            total--;
            grid[i + 1][j] = 2;
        }
        if(j > 0 && grid[i][j - 1] == 1){
            queue.offer(new int[]{i, j - 1});
            total--;
            grid[i][j - 1] = 2;
        }
        if(j < n - 1 && grid[i][j + 1] == 1){
            queue.offer(new int[]{i, j + 1});
            total--;
            grid[i][j + 1] = 2;
        }
    }
}
