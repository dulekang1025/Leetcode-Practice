package Leetcode_621_Task_Scheduler;

import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(int i = 0; i < tasks.length; i++){
            arr[tasks[i] - 'A']++;
        }
        Arrays.sort(arr);
        int ans = 0;
        while(arr[25] > 0){
            int i = 0;
            while(i <= n){
                if(arr[25] <= 0)
                    break;
                if(i < 26 && arr[25 - i] > 0)
                    arr[25 - i]--;
                ans++;
                i++;
            }
            Arrays.sort(arr);
        }
        return ans;
    }
}
