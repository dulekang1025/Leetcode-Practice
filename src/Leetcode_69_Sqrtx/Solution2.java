package Leetcode_69_Sqrtx;

public class Solution2 {
    public int mySqrt(int x) {
        if(x == 1) return 1;
        long low = 0;
        long high = x / 2 + 1;  // important
        long mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(mid * mid > x){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return (int)low - 1;
    }
}
