package Leetcode_227_Basic_Calculator_II;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int calculate(String s) {
        return calc(convert(s));
    }
    private List<String> convert(String s){
        List<String> exp = new LinkedList<>();
        Deque<String> sig = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            // number
            if(Character.isDigit(s.charAt(i))){
                int k = i;
                while(k < s.length() && Character.isDigit(s.charAt(k))){
                    k++;
                }
                exp.add(s.substring(i, k));
                i = k - 1;   // do not want to skip characters
            }
            // * /
            if(s.charAt(i) == '*' || s.charAt(i) == '/'){
                while(!sig.isEmpty() && (sig.peekFirst().equals("*") || sig.peekFirst().equals("/"))){
                    exp.add(sig.pop());
                }
                sig.push(s.charAt(i) + "");
            }
            // + -
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                while(!sig.isEmpty()){
                    exp.add(sig.pop());
                }
                sig.push(s.charAt(i) + "");
            }
        }
        while(!sig.isEmpty()){
            exp.add(sig.pop());
        }
        return exp;
    }
    private int calc(List<String> exp){
        Deque<Integer> stack = new ArrayDeque<>();
        for(String s : exp){
            if(Character.isDigit(s.charAt(0))){
                stack.push(Integer.valueOf(s));
            }else{
                int a = stack.pop();
                int b = stack.pop();
                if(s.equals("+")){
                    stack.push(b + a);
                }else if(s.equals("-")){
                    stack.push(b - a);
                }else if(s.equals("*")){
                    stack.push(b * a);
                }else{
                    stack.push(b / a);
                }
            }
        }
        return stack.pop();
    }
}
