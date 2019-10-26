package Leetcode_58_Length_of_Last_Word;

public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();

        int LastwordLength  = 0;
        int StartIndex = s.length() - 1;

        if(StartIndex < 0){
            return LastwordLength;
        }

        while (StartIndex >= 0 && s.charAt(StartIndex)  != ' '){
            LastwordLength ++;
            StartIndex --;
        }

        return LastwordLength;

    }
}
