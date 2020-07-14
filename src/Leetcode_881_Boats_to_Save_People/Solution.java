package Leetcode_881_Boats_to_Save_People;

import java.util.Arrays;

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int res = 0;
        int left = 0, right = len - 1;
        while(left <= right){
            if(people[left] + people[right] <= limit)
                left++;
            right--;
            res++;
        }
        return res;
    }
}
