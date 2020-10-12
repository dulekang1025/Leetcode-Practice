package Leetcode_859_Buddy_Strings;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean buddyStrings(String A, String B) {
        int a_len = A.length();
        int b_len = B.length();
        if(a_len != b_len) return false;
        int diff = 0;
        Set<Character> set = new HashSet<>();
        boolean ans = false;
        char[] first_pair = new char[2];
        for(int i = 0; i < a_len; i++){
            set.add(A.charAt(i));
            if(A.charAt(i) != B.charAt(i)){
                if(diff == 0){
                    first_pair[0] = A.charAt(i);
                    first_pair[1] = B.charAt(i);
                    diff++;
                }else if(diff == 1){
                    if(A.charAt(i) == first_pair[1] && B.charAt(i) == first_pair[0]){
                        ans = true;
                        diff++;
                    }
                }else{
                    ans = false;
                }
            }
        }
        if(diff == 0){
            if(set.size() < a_len) return true;
            else return false;
        }
        return ans;
    }
}
