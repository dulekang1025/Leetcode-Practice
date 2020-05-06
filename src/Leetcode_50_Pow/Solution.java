package Leetcode_50_Pow;

class Solution {
    public double myPow(double x, int n) {
        if(n > 0){
            return helper(x, n);
        }else{
            return 1 / helper(x, n);
        }
    }
    private double helper(double x, int n){
        if(n == 0) return 1;
        double y = helper(x, n / 2);
        if(n % 2 == 0){
            return y * y;
        }else{
            return y * y * x;
        }
    }
}
