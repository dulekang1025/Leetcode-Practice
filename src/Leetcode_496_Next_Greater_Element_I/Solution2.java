package Leetcode_496_Next_Greater_Element_I;

import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // solution 2 : build a hashmap where key is elements in nums2 and its index as vlaue;
        // this save the time to search postions of nums1's elements in nums2
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], i);
        }
        for(int i = 0; i < nums1.length; i++){
            int next_greater_num = -1;
            int pos = map.get(nums1[i]);
            for(int j = pos; j < nums2.length; j++){
                if(nums1[i] < nums2[j]) {
                    next_greater_num = nums2[j];
                    break;
                }
            }
            ans[i] = next_greater_num;
        }
        return ans;
    }
}
