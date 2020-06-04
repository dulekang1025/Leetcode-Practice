package Leetcode_542_01_Matrix;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        // TODO：dfs impl
        int m = matrix.length;
        int n = matrix[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] ans = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] pos = {{-1, 0}, {1, 0}, {0, -1}, {0, +1}};
        int dis = 0;
        while(!queue.isEmpty()){
            dis++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                for(int j = 0; j < 4; j++){
                    int xx = x + pos[j][0];
                    int yy = y + pos[j][1];
                    if(xx >= 0 && yy >= 0 && xx < m && yy < n && matrix[xx][yy] == 1){
                        ans[xx][yy] = dis;
                        matrix[xx][yy] = 0;
                        queue.offer(new int[]{xx, yy});
                    }
                }
            }
        }
        return ans;
    }
}