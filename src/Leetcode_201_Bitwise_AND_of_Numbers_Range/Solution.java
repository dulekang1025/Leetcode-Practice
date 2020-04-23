package Leetcode_201_Bitwise_AND_of_Numbers_Range;

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while(m != n){
            m = m>>1;
            n = n>>1;
            count++;
        }
        return m<<count;
    }
}
