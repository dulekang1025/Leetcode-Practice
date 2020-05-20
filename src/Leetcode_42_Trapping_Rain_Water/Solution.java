package Leetcode_42_Trapping_Rain_Water;

import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!s.isEmpty() && height[i] > height[s.peek()]){
                int top = s.pop();
                if(s.isEmpty()) break;
                int h = Math.min(height[i], height[s.peek()]) - height[top];
                int w = i - s.peek() - 1;
                res += h * w;
            }
            s.push(i);
        }
        return res;
    }
}
