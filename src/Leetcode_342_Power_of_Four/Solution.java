package Leetcode_342_Power_of_Four;

class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 0 || num < 0) return false;
        while(num > 1){
            if(num % 4 != 0) return false;
            num = num / 4;
        }
        if(num == 1) return true;
        else return false;
    }
}
