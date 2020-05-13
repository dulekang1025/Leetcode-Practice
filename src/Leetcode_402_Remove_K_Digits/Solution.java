package Leetcode_402_Remove_K_Digits;

import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        if(k == 0) return num;
        Stack<Character> stack = new Stack<>();
        char[] digits = num.toCharArray();
        for(int i = 0; i < digits.length; i++){
            while(k > 0 && !stack.isEmpty() && stack.peek() > digits[i]){
                //System.out.println("pop: " + stack.pop());
                stack.pop();
                k--;
            }
            //System.out.println("push: " + stack.push(digits[i]));
            stack.push(digits[i]);
        }
        while(k > 0){
            //System.out.println("pop: " + stack.pop());
            stack.pop();
            k--;
        }
        boolean leadingZero = true;
        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            if(leadingZero && c == '0') continue;
            leadingZero = false;
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
