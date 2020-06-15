package Leetcode_1011_Capacity_To_Ship_Packages_Within_D_Days;

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int low = 0, high = 0, mid = 0;
        for(int n : weights){
            low = Math.max(n, low);
            high += n;
        }
        while(low < high){
            mid = low + (high - low) / 2;
            int days = load(weights, mid);
            if(days > D)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    private int load(int[] weis, int cap){
        int temp = 0;
        int res = 1;
        for(int n : weis){
            temp += n;
            if(temp > cap){
                res++;
                temp = n;
            }
        }
        return res;
    }
}
