package Leetcode_1508_Range_Sum_of_Sorted_Subarray_Sums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                sums.add(sum);
            }
        }
        Collections.sort(sums);
        //System.out.println(sums);
        int ans = 0;
        for(int i = left - 1; i <= right - 1; i++){
            ans += sums.get(i);
        }
        return ans;
    }
}
