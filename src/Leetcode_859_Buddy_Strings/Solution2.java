package Leetcode_859_Buddy_Strings;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public boolean buddyStrings(String A, String B) {
        // If length are not same, return false;
        if(A.length() != B.length()) return false;
        char[] diff = new char[2];
        int countDiff = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < A.length(); i++){
            set.add(A.charAt(i));
            if(A.charAt(i) != B.charAt(i)){
                if(countDiff == 0){
                    diff[0] = A.charAt(i);
                    diff[1] = B.charAt(i);
                    countDiff++;
                }else if(countDiff == 1){
                    if(diff[0] != B.charAt(i) || diff[1] != A.charAt(i)){
                        return false;
                    }
                    countDiff++;
                } else{
                    return false;
                }
            }
        }
        if((countDiff == 0 && set.size() == A.length()) || countDiff == 1){
            return false;
        }
        return true;
    }
}