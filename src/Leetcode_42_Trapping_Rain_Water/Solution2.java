package Leetcode_42_Trapping_Rain_Water;

public class Solution2 {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0) return 0;
        int[] right_highest = new int[n];
        int[] left_highest = new int[n];
        int res = 0;
        right_highest[0] = height[0];
        for(int i = 1; i < n; i++){
            right_highest[i] = Math.max(right_highest[i - 1], height[i]);
        }
        left_highest[n - 1] = height[n - 1];
        for(int i = n - 2; i >= 0 ; i--){
            left_highest[i] = Math.max(left_highest[i + 1], height[i]);
        }
        for(int i = 0; i < n; i++){
            res += Math.min(right_highest[i], left_highest[i]) - height[i];
        }
        return res;
    }
}
