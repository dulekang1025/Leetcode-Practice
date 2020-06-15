package Leetcode_1482_Minimum_Number_of_Days_to_Make_m_Bouquets;

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }
        int high = 0;
        for(int n : bloomDay){
            high = Math.max(high, n);
        }
        int low = 0, mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            int flowerNum = count(bloomDay, mid, k);
            if(flowerNum >= m){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    private int count(int[] bloomDay, int day, int k){
        int res = 0;
        int count = 0;
        for(int n : bloomDay){
            if(n <= day){
                count++;
            }else{
                count = 0;
            }
            if(count == k){
                res++;
                count = 0;
            }
        }
        return res;
    }
}
