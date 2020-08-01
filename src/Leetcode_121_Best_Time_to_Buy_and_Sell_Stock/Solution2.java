package Leetcode_121_Best_Time_to_Buy_and_Sell_Stock;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int[] p2 = new int[prices.length + 1];
        for(int i = 0; i < prices.length; i++){
            p2[i] = prices[i];
        }
        p2[p2.length - 1] = -1;
        Deque<Integer> s = new ArrayDeque<>();
        for(int i = 0; i < p2.length; i++){
            while(!s.isEmpty() && s.peek() >= p2[i]){
                int top = s.pop();
                if(s.isEmpty()) break;
                ans = Math.max(ans, top - s.peekLast());
            }
            s.push(p2[i]);
        }
        return ans;
    }
}
