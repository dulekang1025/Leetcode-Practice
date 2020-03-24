package Leetcode_739_Daily_Temperatures;

import java.util.Stack;

public class Solution2 {
    // using stack maintaining decreasing order of elements
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < T.length; i++){
            while(!s.isEmpty() && T[i] > T[s.peek()]){
                int c = s.pop();
                ans[c] = i - c;
            }
            s.push(i);
        }
        return ans;
    }
}
