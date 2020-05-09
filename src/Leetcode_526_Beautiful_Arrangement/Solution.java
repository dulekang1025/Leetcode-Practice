package Leetcode_526_Beautiful_Arrangement;

class Solution {
    boolean[] visited;
    int count = 0;
    int n = 0;
    public int countArrangement(int N) {
        visited = new boolean[N + 1];
        n = N;
        dfs(1);
        return count;
    }
    private void dfs(int pos){
        if(pos > n){   // 下一层结束， == n时还没结束
            count++;
            return;
        }
        for(int i = 1; i <= n; i++){
            if(!visited[i] && ((pos % i == 0) || (i % pos == 0))){
                visited[i] = true;
                dfs(pos + 1);
                visited[i] = false;
            }
        }
    }
}
