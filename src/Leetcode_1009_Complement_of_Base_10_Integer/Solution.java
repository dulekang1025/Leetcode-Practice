package Leetcode_1009_Complement_of_Base_10_Integer;

class Solution {
    public int bitwiseComplement(int N) {
        int mask = 1; int temp = N;
        while(temp > 0){
            mask = mask<<1;
            temp = temp>>1;
        }
        return N != 0 ? N ^ (mask - 1) : N ^ mask;
    }
}
