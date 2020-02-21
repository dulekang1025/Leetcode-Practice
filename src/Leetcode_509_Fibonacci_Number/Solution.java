package Leetcode_509_Fibonacci_Number;

class Solution {
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        return find(0, 1, N - 2);
    }
    public int find(int f0, int f1, int N){
        if(N < 0) return f1;
        int temp = f0 + f1;
        f0 = f1;
        f1 = temp;
        return find(f0, f1, N - 1);
    }
}
