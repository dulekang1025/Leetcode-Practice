package Leetcode_1137_N_th_Tribonacci_Number;

class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return helper(0, 1, 1, n - 3);
    }
    public int helper(int t0, int t1, int t2, int n){
        if(n < 0) return t2;
        int nxt = t0 + t1 + t2;
        t0 = t1;
        t1 = t2;
        t2 = nxt;
        return helper(t0, t1, t2, n-1);
    }
}
