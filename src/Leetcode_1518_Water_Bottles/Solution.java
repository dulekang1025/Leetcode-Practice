package Leetcode_1518_Water_Bottles;

class Solution {
    public int numWaterBottles(int numBottles, int k) {
        int empty = 0;
        int full = numBottles;
        int ans = 0;
        while(full > 0){
            ans += full;
            empty = full + empty;
            full = empty / k;
            empty = empty % k;
        }
        return ans;
    }
}
