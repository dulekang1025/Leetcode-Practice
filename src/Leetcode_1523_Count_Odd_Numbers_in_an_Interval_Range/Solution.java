package Leetcode_1523_Count_Odd_Numbers_in_an_Interval_Range;

class Solution {
    public int countOdds(int low, int high) {
        //If x is even, you start from exercise x’=x+1. Otherwise you start at x.
        //If y is even, you end at exercise y’=y-1. Otherwise you end at y.
        //The total number of exercises is n=(y’-x’)/2+1.
        low = low % 2 == 0 ?  low + 1 : low;
        high = high % 2 == 0 ? high - 1 : high;
        int ans = (high - low) / 2 + 1;
        return ans;
    }
}
