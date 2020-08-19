package Leetcode_824_Goat_Latin;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public String toGoatLatin(String S) {
        char[] arr = new char[]{'a','e','i','o','u'};
        Set<Character> set = new HashSet<>();
        for(char c : arr) set.add(c);
        StringBuilder sb = new StringBuilder();
        String[] s = S.split(" ");
        for(int i = 0; i < s.length; i++){
            if(set.contains(Character.toLowerCase(s[i].charAt(0)))){
                sb.append(s[i]);
                sb.append("ma");
            }else{
                sb.append(s[i].substring(1, s[i].length()));
                sb.append(s[i].charAt(0));
                sb.append("ma");
            }
            for(int j = 0; j < i + 1; j++){
                sb.append('a');
            }
            if(i != s.length - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
