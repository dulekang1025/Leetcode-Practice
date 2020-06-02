package Leetcode_947_Most_Stones_Removed_with_Same_Row_or_Column;

class Solution {
    class UN{
        int[] parent;
        int[] rank;
        int count;
        public UN(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }
        public int find(int x){
            if(x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX == rootY) return;
            if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
                rank[rootX] += rank[rootY];
            }else{
                parent[rootX] = rootY;
                rank[rootY] += rank[rootX];
            }
            count--;
        }
        public int getCount(){
            return count;
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UN un = new UN(n);
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                    un.union(i, j);
                }
            }
        }
        return n - un.getCount();
    }
}
