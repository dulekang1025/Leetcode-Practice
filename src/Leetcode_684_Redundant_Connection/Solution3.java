package Leetcode_684_Redundant_Connection;

class Solution3 {
    class DSU{
        int[] p;
        int[] r;
        public DSU(int n){
            p = new int[n];
            r = new int[n];
            for(int i = 0; i < n; i++){
                p[i] = i;
            }
        }
        public int find(int x){
            int rootX = x;
            while(p[rootX] != rootX){
                rootX = p[rootX];
            }
            return rootX;
        }
        public boolean union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY){
                return false;
            }else{
                if(r[rootX] > r[rootY]){
                    p[rootY] = rootX;
                }else if(r[rootY] > r[rootX]){
                    p[rootX] = rootY;
                }else{
                    p[rootX] = rootY;
                    r[rootY]++;
                }
                return true;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n + 1);
        for(int[] e : edges){
            if(!dsu.union(e[0], e[1])) return e;
        }
        return new int[0];
    }
}
