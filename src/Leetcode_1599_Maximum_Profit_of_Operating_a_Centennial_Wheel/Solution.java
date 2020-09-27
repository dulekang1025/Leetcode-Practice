package Leetcode_1599_Maximum_Profit_of_Operating_a_Centennial_Wheel;

class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int wait = 0;
        int load = 0;
        int max = 0;
        int time = 1;
        int ans = 0;
        for(int i = 0; i < customers.length; i++){
            wait += customers[i];
            if(wait >= 4){
                load += 4;
                wait -= 4;
            }else{
                load += wait;
                wait = 0;
            }
            int sum = load * boardingCost - time * runningCost;
            // System.out.println(load + " " + wait + " " + sum);
            time++;
            if(max < sum){
                max = sum;
                ans = time;
            }
        }
        while(wait != 0){
            if(wait >= 4){
                load += 4;
                wait -= 4;
            }else{
                load += wait;
                wait = 0;
            }
            int sum = load * boardingCost - time * runningCost;
            time++;
            if(max < sum){
                max = sum;
                ans = time;
            }
        }
        return max == 0 ? -1 : ans - 1;
    }
}
