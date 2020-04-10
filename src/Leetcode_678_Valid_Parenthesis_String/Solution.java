package Leetcode_678_Valid_Parenthesis_String;

import java.util.Stack;

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> pare = new Stack<>(); // parenthesis stack
        Stack<Integer> star = new Stack<>(); // star stack
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(') pare.push(i);
            else if(s.charAt(i) == '*') star.push(i);
            else{
                if(pare.isEmpty() && star.isEmpty()) return false;
                if(!pare.isEmpty()) pare.pop();
                else star.pop();
            }
        }
        while(!pare.isEmpty() && !star.isEmpty()){
            if(pare.peek() > star.peek()) return false;
            pare.pop();
            star.pop();
        }
        return pare.isEmpty();
    }
}
