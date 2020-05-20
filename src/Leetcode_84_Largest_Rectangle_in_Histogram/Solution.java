package Leetcode_84_Largest_Rectangle_in_Histogram;

import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> s = new Stack<>();
        int n = heights.length;
        s.push(-1);
        for(int i = 0; i < n; i++){
            while(s.peek() != -1 && heights[s.peek()] >= heights[i]){
                int h = heights[s.pop()];
                max = Math.max(max, h * (i - s.peek() - 1));
            }
            s.push(i);
        }
        while(s.peek() != -1){
            int h = heights[s.pop()];
            max = Math.max(max, h * (n - s.peek() - 1));
        }
        return max;
    }
}
