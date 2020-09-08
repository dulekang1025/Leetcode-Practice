package Leetcode_1578_MinimumDeletionCostToAvoidRepeatingLetters;

class Solution {
    public int minCost(String s, int[] cost) {
        int res = 0, max = 0, sum = 0, n = cost.length;
        for(int i = 0; i < n; i++){
            if(i > 0 && s.charAt(i) != s.charAt(i - 1)){
                res += sum - max;
                sum = max = 0;
            }
            sum += cost[i];
            max = Math.max(max, cost[i]);
        }
        res += sum - max;
        return res;
    }
}
