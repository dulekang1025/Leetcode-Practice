package Leetcode_204_Count_Primes;

class Solution {
    public int countPrimes(int n) {
        boolean[] mark = new boolean[n];
        int res = 0;
        for(int i = 2; i < n; i++){
            if(mark[i]) continue;
            res++;
            for(int j = 2; j * i < n; j++){
                mark[i * j] = true;
            }
        }
        return res;
    }
}
