package Leetcode_53_Maximum_Subarray;

public class Solution2 {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cur = 0;
        for(int i : nums){
            cur = Math.max(i, cur + i);
            res = Math.max(res, cur);
        }
        return res;
    }
}
