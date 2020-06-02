package Leetcode_990_Satisfiability_of_Equality_Equations;

class Solution {
    class UN{
        int[] parent;
        int[] rank;
        public UN(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x] != x){
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
        }
    }

    public boolean equationsPossible(String[] equations) {
        UN un = new UN(26);
        for(String s : equations){
            if(s.charAt(1) == '='){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                un.union(a, b);
            }
        }
        for(String s : equations){
            if(s.charAt(1) == '!'){
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                int rootA = un.find(a);
                int rootB = un.find(b);
                if(rootA == rootB) return false;
            }
        }
        return true;
    }
}
