package Leetcode_125_Valid_Palindrome;

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        s = s.trim();
        int start = 0, end = s.length() - 1;
        while(start < end){
            while(!Character.isLetterOrDigit(s.charAt(start)) && start < end)
                ++start;
            while(!Character.isLetterOrDigit(s.charAt(end)) && start < end)
                --end;
            if(s.charAt(start)!=s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
