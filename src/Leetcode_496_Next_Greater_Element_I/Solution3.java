package Leetcode_496_Next_Greater_Element_I;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution3 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // solution 3 : build a hashmap which records all the numbers nextGreaterElement in nums2
        int[] ans = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack();
        for(int i = 0; i < nums2.length; i++){
            while(!s.isEmpty() && s.peek() < nums2[i]){
                map.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
        }
        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}
