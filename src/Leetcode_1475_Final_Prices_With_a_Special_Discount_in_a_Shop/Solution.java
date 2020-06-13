package Leetcode_1475_Final_Prices_With_a_Special_Discount_in_a_Shop;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            boolean has = false;
            for(int j = i + 1; j < n; j++){
                if(prices[j] <= prices[i]){
                    ans[i] = prices[i] - prices[j];
                    has = true;
                    break;
                }
            }
            if(!has){
                ans[i] = prices[i];
            }
        }
        return ans;
    }
}
