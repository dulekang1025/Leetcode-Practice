package Leetcode_686_Repeated_String_Match;

class Solution {
    public int repeatedStringMatch(String A, String B) {
        // let A repeat
        String temp = "";
        int n = 0;
        while(temp.length() < B.length()){
            temp += A;
            n++;
        }
        if(temp.indexOf(B) >= 0) return n;
        temp += A;
        n++;
        return temp.indexOf(B) >= 0 ? n : -1;
    }
}
