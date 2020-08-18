package Leetcode_967_Numbers_With_Same_Consecutive_Differences;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> ans;
    int N;
    int K;
    public int[] numsSameConsecDiff(int N, int K) {
        this.ans = new ArrayList<>();
        this.N = N;
        this.K = K;
        if(N == 1){
            ans.add(0);
        }
        for(int i = 1; i < 10; i++){
            dfs(i, i, 1);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
    private void dfs(int cur, int n, int count){
        if(count == N){
            ans.add(cur);
            return;
        }
        int t1 = n + K;
        int t2 = n - K;
        if(t1 >= 0 && t1 <= 9){
            dfs(cur * 10 + t1, t1, count + 1);
        }
        if(t1 != t2 && t2 >= 0 && t2 <= 9){
            dfs(cur * 10 + t2, t2, count + 1);
        }
    }
}
