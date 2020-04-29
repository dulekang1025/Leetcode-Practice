package Leetcode_367_Valid_Perfect_Square;

class Solution {
    public boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;
        long mid = 0;
        while(low <= high){
            mid = low + (high - low) / 2;
            long t = mid * mid;
            if(t > num){
                high = mid - 1;
            }else if(t < num){
                low = mid + 1;
            }else return true;
        }
        return false;
    }
}
