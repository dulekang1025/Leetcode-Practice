package Leetcode_263_Ugly_Number;

class Solution {
    public boolean isUgly(int num) {
        while(num > 1 &&(num%2 == 0 || num%3 == 0 || num%5 == 0 ) ){
            if(num%2 == 0) num /= 2;
            if(num%3 == 0) num /= 3;
            if(num%5 == 0) num /= 5;
        }
        return num == 1;
    }
}