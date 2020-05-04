package Leetcode_476_Number_Complement;

class Solution {
    public int findComplement(int num) {
        int mask = 1; int temp = num;
        while(temp > 0){
            mask = mask<<1;
            temp = temp>>1;
        }
        return num != 0 ? num ^ (mask - 1) : num ^ mask;
    }
}
