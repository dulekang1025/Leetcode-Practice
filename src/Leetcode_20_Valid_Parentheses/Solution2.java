package Leetcode_20_Valid_Parentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '(') return false;
            }else if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{') return false;
            }else if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
