package Leetcode_547_FriendCircles;

class Solution2 {
    public int findCircleNum(int[][] M) {
        int res = 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(M, visited, i);
                res++;
            }
        }
        return res;
    }
    private void dfs(int[][] M, boolean[] visited, int i){
        if(visited[i]) return;
        visited[i] = true;
        for(int j = 0; j < M[i].length; j++){
            if(i != j && M[i][j] == 1){
                dfs(M, visited, j);
            }
        }
    }
}
