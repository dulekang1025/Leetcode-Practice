package Leetcode_456_132_Pattern;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean find132pattern(int[] nums) {
        int second = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < second) return true;
            while(!stack.isEmpty() && nums[i] > stack.peek()) second = stack.pop();
            stack.push(nums[i]);
        }
        return false;
    }
}
