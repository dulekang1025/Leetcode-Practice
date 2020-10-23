package Leetcode_735_Asteroid_Collision;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0) stack.push(asteroids[i]);
            else{
                int cur = asteroids[i];
                while(cur < 0 && !stack.isEmpty() && stack.peek() > 0){
                    int prev = stack.pop();
                    if(Math.abs(cur) > Math.abs(prev)){
                        continue;
                    }else if(Math.abs(cur) < Math.abs(prev)){
                        cur = prev;
                    }else{
                        cur = 0;
                    }
                }
                if(cur != 0) stack.push(cur);
            }
        }
        int[] res = new int[stack.size()];
        for(int i = stack.size() - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}

