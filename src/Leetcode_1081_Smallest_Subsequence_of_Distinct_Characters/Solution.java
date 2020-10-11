package Leetcode_1081_Smallest_Subsequence_of_Distinct_Characters;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String smallestSubsequence(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.contains(c)) continue;
            while(!stack.isEmpty() && stack.peek() > c && last[stack.peek() - 'a'] > i){
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
