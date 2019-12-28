package Leetcode_231_Power_of_Two;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 0 || n == 0) return false;
        int c = 0;
        while(n != 0){
            if((n&1) == 1) c++;
            n >>>= 1;
        }
        if(c == 1) return true;
        else return false;
    }
}
