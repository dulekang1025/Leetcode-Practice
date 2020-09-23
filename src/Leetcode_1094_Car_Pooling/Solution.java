package Leetcode_1094_Car_Pooling;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] load = new int[1001];
        for(int i = 0; i < trips.length; i++){
            load[trips[i][1]] += trips[i][0];
            load[trips[i][2]] -= trips[i][0];
        }
        int sum = 0;
        for(int i = 0; i < 1001; i++){
            sum += load[i];
            if(sum > capacity){
                return false;
            }
        }
        return true;
    }
}
