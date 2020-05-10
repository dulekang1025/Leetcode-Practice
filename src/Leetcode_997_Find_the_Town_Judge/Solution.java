package Leetcode_997_Find_the_Town_Judge;

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] out = new int[N + 1];
        int[] in = new int[N + 1];
        for(int i = 0; i < trust.length; i++){
            out[trust[i][0]]++;
            in[trust[i][1]]++;
        }
        for(int i = 1; i <= N; i++){
            if(out[i] == 0 && in[i] == N - 1)
                return i;
        }
        return -1;
    }
}
