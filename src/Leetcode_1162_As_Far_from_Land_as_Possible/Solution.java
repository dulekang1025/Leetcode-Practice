package Leetcode_1162_As_Far_from_Land_as_Possible;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int waterCount = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }else{
                    waterCount++;
                }
            }
        }
        int distance = 0;
        while(!queue.isEmpty() && waterCount > 0){
            int size = queue.size();
            distance++;
            for(int k = 0; k < size; k++){
                int[] cur = queue.poll();
                int i = cur[0];
                int j = cur[1];
                if(i - 1 >= 0 && grid[i - 1][j] == 0){
                    waterCount--;
                    grid[i - 1][j] = 1;
                    queue.offer(new int[]{i - 1, j});
                }
                if(i + 1 < n && grid[i + 1][j] == 0){
                    waterCount--;
                    grid[i + 1][j] = 1;
                    queue.offer(new int[]{i + 1, j});
                }
                if(j - 1 >= 0 && grid[i][j - 1] == 0){
                    waterCount--;
                    grid[i][j - 1] = 1;
                    queue.offer(new int[]{i, j - 1});
                }
                if(j + 1 < n && grid[i][j + 1] == 0){
                    waterCount--;
                    grid[i][j + 1] = 1;
                    queue.offer(new int[]{i, j + 1});
                }
            }
        }
        return queue.size() == n * n || waterCount == n * n ? -1 : distance;
    }
}
