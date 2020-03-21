package Leetcode_9_Palindrome_Number;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int temp = x;
        Stack<Integer> s = new Stack<>();
        while(temp > 0){
            int p = temp % 10;
            temp /= 10;
            s.push(p);
        }
        temp = x;
        Queue<Integer> q = new LinkedList<>();
        while(temp > 0){
            int p = temp % 10;
            temp /= 10;
            q.add(p);
        }
        while(!q.isEmpty() && !s.isEmpty()){
            if(q.poll() != s.pop()) return false;
        }
        return true;
    }
}