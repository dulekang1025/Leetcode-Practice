package Leetcode_1267_Count_Servers_that_Communicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int countServers(int[][] grid) {
        List<int[]> arr = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    arr.add(new int[]{i, j});
                }
            }
        }
        UN un = new UN(arr.size());
        for(int i = 0; i < arr.size() - 1; i++){
            int[] a = arr.get(i);
            for(int j = i + 1; j < arr.size(); j++){
                int[] b = arr.get(j);
                if(a[0] == b[0] || a[1] == b[1]){
                    un.union(i, j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < arr.size(); i++){
            if(un.p[i] == i && un.size[i] == 1){
                count++;
            }
        }
        return arr.size() - count;
    }
    class UN{
        int[] p;
        int[] size;
        public UN(int n){
            p = new int[n];
            size = new int[n];
            for(int i = 0; i < n; i++){
                p[i] = i;
            }
            Arrays.fill(size, 1);
        }
        public int find(int a){
            if(p[a] != a){
                p[a] = find(p[a]);
            }
            return p[a];
        }
        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB) return;
            if(size[rootA] > size[rootB]){
                p[rootB] = rootA;
                size[rootA] += size[rootB];
            }else{
                p[rootA] = rootB;
                size[rootB] += size[rootA];
            }
        }
    }
}
