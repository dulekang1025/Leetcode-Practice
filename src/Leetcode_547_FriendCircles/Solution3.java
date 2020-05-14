package Leetcode_547_FriendCircles;

import java.util.Arrays;

class Solution3 {
    class UnionFound{
        int[] p;
        int[] r;
        int cycle;
        public UnionFound(int n){
            p = new int[n];
            r = new int[n];
            cycle = n;
            Arrays.fill(p, -1);
        }
        public int find(int x){
            int rootX = x;
            while(p[rootX] != -1){
                rootX = p[rootX];
            }
            return rootX;
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            else{
                if(r[rootX] > r[rootY]){
                    p[rootY] = rootX;
                }else if(r[rootY] > r[rootX]){
                    p[rootX] = rootY;
                }else{
                    p[rootX] = rootY;
                    r[rootY]++;
                }
            }
            cycle--;
        }
    }
    public int findCircleNum(int[][] M) {
        UnionFound uf = new UnionFound(M.length);
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j <= i; j++){
                if(M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.cycle;
    }
}
