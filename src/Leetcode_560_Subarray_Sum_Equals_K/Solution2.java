package Leetcode_560_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int subarraySum(int[] nums, int k) {
        // prefix sum, nums[j] - nums[i] == k, (i < j)
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, 1); // important
        for(int n : nums){
            sum += n;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
