package Leetcode_1552_Magnetic_Force_Between_Two_Balls;

import java.util.Arrays;

class Solution {
    public int maxDistance(int[] pos, int m) {
        int ans = -1;
        Arrays.sort(pos);
        int low = 1, high = pos[pos.length - 1]; // why low starts from 1 ?
        while(low < high){
            int mid = low + (high - low) / 2;
            if(helper(pos, m, mid)){
                low = mid + 1;
                ans = Math.max(ans, mid);
            }else{
                high = mid;
            }
        }
        return ans;
    }
    private boolean helper(int[] pos, int m, int mid){
        int count = 1;
        int pre = pos[0];
        for(int i = 0; i < pos.length; i++){
            if(pos[i] - pre >= mid){
                count++;
                pre = pos[i];
            }
        }
        return count >= m;
    }
}

// [1,2,3,4,7]
// 3
// [5,4,3,2,1,1000000000]
// 2
