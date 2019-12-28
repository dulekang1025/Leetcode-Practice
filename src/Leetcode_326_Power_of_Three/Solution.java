package Leetcode_326_Power_of_Three;

class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 0 || n == 0) return false;
        while(n > 1){
            if(n % 3 != 0)  return false;
            n = n / 3;
        }
        if(n == 1) return true;
        else return false;
    }
}
