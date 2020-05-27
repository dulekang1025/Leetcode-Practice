package Leetcode_441_Arranging_Coins;

class Solution {
    public int arrangeCoins(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int ans = 0;
        int sum = n;
        for(int i = 1; i <= n; i++){
            if(i > sum){
                ans = i - 1;
                break;
            }
            sum -= i;
        }
        return ans;
    }
}
