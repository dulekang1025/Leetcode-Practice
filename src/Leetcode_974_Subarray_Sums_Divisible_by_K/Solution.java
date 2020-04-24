package Leetcode_974_Subarray_Sums_Divisible_by_K;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] A, int K) {
        // basically the same with 523, this one has no length limitation
        // divisible by k == equals to multiple of k
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>(); // (sum, times)
        map.put(0,1);
        for(int i = 0; i < A.length; i++){
            sum += A[i];
            int t = K == 0 ? sum : sum % K;
            if(t < 0) t += K;   // why ?
            ans += map.getOrDefault(t, 0);
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        return ans;
    }
}
