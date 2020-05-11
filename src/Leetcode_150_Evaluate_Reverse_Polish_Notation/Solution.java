package Leetcode_150_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first - second);
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("/")){
                int btm = stack.pop();
                int top = stack.pop();
                stack.push(top / btm);
            }else{
                int temp = Integer.valueOf(s);
                stack.push(temp);
            }
        }
        return stack.pop();
    }
}
