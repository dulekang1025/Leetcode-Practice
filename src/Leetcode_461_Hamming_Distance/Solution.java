package Leetcode_461_Hamming_Distance;

class Solution {
    public int hammingDistance(int x, int y) {
        if(x == y) return 0;
        int res = 0;
        while(x != 0 || y != 0){
            if(((x&1) ^ (y&1)) == 1) res++;
            x = x>>1;
            y = y>>1;
        }
        return res;
    }
}
