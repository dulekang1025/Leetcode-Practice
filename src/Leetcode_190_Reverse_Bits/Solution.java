package Leetcode_190_Reverse_Bits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        boolean negtive = n < 0;
        int ans = 0;
        for(int i = 0; i < 31; i++){
            if((n&1) == 1) ans++;
            ans = ans << 1;
            n = n >> 1;
        }
        return negtive ? ans+1 : ans;
    }
}
