package Leetcode_1673_Find_the_Most_Competitive_Subsequence;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int len = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            while(!stack.isEmpty() && nums[i] < stack.peek() && k - stack.size() < len - i){
                stack.pop();
            }
            if(stack.size() < k){
                stack.push(nums[i]);
            }
        }
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}
