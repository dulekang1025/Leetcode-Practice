package Leetcode_495_Teemo_Attacking;

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0) return 0;
        int[] time = new int[2];
        time[0] = timeSeries[0];
        time[1] = time[0] + duration;
        int sum = 0;
        for(int i = 1; i < timeSeries.length; i++){
            if(time[1] >= timeSeries[i]){
                time[1] = timeSeries[i] + duration;
            }else{
                sum += time[1] - time[0];
                time[0] = timeSeries[i];
                time[1] = time[0] + duration;
            }
        }
        sum += time[1] - time[0];
        return sum;
    }
}
