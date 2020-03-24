package Leetcode_503_Next_Greater_Element_II;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    // use reminder to visit the array twice.
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> s = new Stack();
        for(int i = 0; i < nums.length * 2; i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i % nums.length]){
                ans[s.pop()] = nums[i % nums.length];
            }
            if(i < nums.length) s.push(i);
        }
        return ans;
    }
}
