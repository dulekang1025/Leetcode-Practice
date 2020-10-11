package Leetcode_316_Remove_Duplicate_Letters;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++){
            last[s.charAt(i) - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            if(stack.contains(s.charAt(i))) continue;
            while(!stack.isEmpty() && (stack.peek() > s.charAt(i) && last[stack.peek() - 'a'] > i)){
                stack.pop();
            }
            stack.push(s.charAt(i));
        }
        //System.out.println(stack);
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
