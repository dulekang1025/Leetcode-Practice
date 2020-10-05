package Leetcode_1608_Special_Array_With_X_Elements_Greater_Than_or_Equal_X;

import java.util.Arrays;

class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Integer ans = null;
        // [0,4,3,0,4]  3
        for(int i = 0; i <= len; i++){
            int count = 0;
            for(int j = 0; j < len; j++){
                if(nums[j] >= i){
                    // System.out.println(i + " " + nums[j] + " " + count + " lll");
                    count++;
                }else{
                    // System.out.println(i + " " + j + " " + count);
                    continue;
                }
            }
            if(count == i){
                System.out.println(i);
                ans = i;
                break;
            }
        }
        return ans == null ? -1 : ans;
    }
}
