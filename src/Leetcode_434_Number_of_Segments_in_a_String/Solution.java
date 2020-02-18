package Leetcode_434_Number_of_Segments_in_a_String;

class Solution {
    public int countSegments(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' ') continue;
            res++;
            while(i<s.length() && s.charAt(i) != ' ') i++;
        }
        return res;
    }
}
