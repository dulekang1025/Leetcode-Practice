package Leetcode_1417_Reformat_The_String;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String reformat(String s) {
        int len = s.length();
        Queue<Character> charQueue = new LinkedList<>();
        Queue<Character> digitQueue = new LinkedList<>();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            if(Character.isLetter(c)){
                charQueue.add(c);
            }else{
                digitQueue.add(c);
            }
        }
        if(Math.abs(charQueue.size() - digitQueue.size()) > 1) return "";
        Queue<Character> first = null;
        Queue<Character> second = null;
        if(charQueue.size() > digitQueue.size()){
            first = charQueue;
            second = digitQueue;
        }else{
            first = digitQueue;
            second = charQueue;
        }
        StringBuilder sb = new StringBuilder();
        while(!first.isEmpty() || !second.isEmpty()){
            if(!first.isEmpty())
                sb.append(first.poll());
            if(!second.isEmpty())
                sb.append(second.poll());
        }
        return sb.toString();
    }
}
