package Leetcode_29_Divide_Two_Integers;

class Solution {
    public int divide(int dividend, int divisor) {
        int res = 0;
        // sign
        int sign = 1;
        if((dividend < 0 && divisor > 0)||(dividend > 0 && divisor < 0)) sign = -1;
        // overflow
        long top = Math.abs((long)dividend);
        long btm = Math.abs((long)divisor);
        // get zero res
        if(top == 0 || top < btm) return 0;
        long lres = helper(top, btm);
        if(lres > Integer.MAX_VALUE){
            return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else{
            return (int)(sign * lres);
        }
    }
    private long helper(long dividend, long divisor){
        if(dividend < divisor) return 0;
        long times = 1;
        long sum = divisor;
        while(sum + sum <= dividend){
            times += times;
            sum += sum;
        }
        return times + helper(dividend - sum, divisor);
    }
}
