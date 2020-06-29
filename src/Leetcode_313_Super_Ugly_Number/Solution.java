package Leetcode_313_Super_Ugly_Number;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] ans = new int[n];
        int[] index = new int[len];
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < len; j++){
                min = Math.min(min, ans[index[j]] * primes[j]);
            }
            ans[i] = min;
            for(int j = 0; j < len; j++){
                if(ans[i] == ans[index[j]] * primes[j]){
                    index[j]++;
                }
            }
        }
        return ans[n - 1];
    }
}
