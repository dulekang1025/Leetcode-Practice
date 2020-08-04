package Leetcode_342_Power_of_Four;

public class Solution2 {
    public boolean isPowerOfFour(int num) {
        if(num > 0){
            while(num % 4 == 0){
                num /= 4;
            }
        }
        return num == 1;
    }
}
