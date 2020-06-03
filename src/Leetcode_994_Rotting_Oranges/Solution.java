package Leetcode_994_Rotting_Oranges;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        int time = 0;
        while(!queue.isEmpty() && count > 0){
            time++;
            int size = queue.size();
            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if(i - 1 >= 0 && grid[i - 1][j] == 1){  // up
                    count--;
                    grid[i - 1][j] = 2;
                    queue.offer(new int[]{i - 1, j});
                }
                if(i < m - 1 && grid[i + 1][j] == 1){  // down
                    count--;
                    grid[i + 1][j] = 2;
                    queue.offer(new int[]{i + 1, j});
                }
                if(j - 1 >= 0 && grid[i][j - 1] == 1){  // left
                    count--;
                    grid[i][j - 1] = 2;
                    queue.offer(new int[]{i, j - 1});
                }
                if(j < n - 1 && grid[i][j + 1] == 1){  // right
                    count--;
                    grid[i][j + 1] = 2;
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
        return count == 0 ? time : -1;
    }
}
