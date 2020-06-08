package Leetcode_231_Power_of_Two;

class Solution2 {
    public boolean isPowerOfTwo(int n) {
        while(n > 0){
            if(n == 1)
                return true;
            if(n % 2 != 0)
                return false;
            n /= 2;
        }
        return false;
    }
}
