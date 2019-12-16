package Leetcode_344_Reverse_String;

class Solution {
    public void reverseString(char[] s) {
        if(s.length == 0) return;
        int start = 0;
        int end = s.length - 1;
        while(start < end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
}
