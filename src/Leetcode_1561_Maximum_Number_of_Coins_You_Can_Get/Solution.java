package Leetcode_1561_Maximum_Number_of_Coins_You_Can_Get;

import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length / 3;
        Arrays.sort(piles);
        int p = piles.length - 2;
        int ans = 0;
        while(n > 0){
            ans += piles[p];
            p -= 2;
            n--;
        }
        return ans;
    }
}
