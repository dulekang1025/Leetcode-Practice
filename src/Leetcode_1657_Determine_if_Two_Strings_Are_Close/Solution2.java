package Leetcode_1657_Determine_if_Two_Strings_Are_Close;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public boolean closeStrings(String word1, String word2) {
        if(word1.equals(word2)) return true;
        if(word1.length() != word2.length()) return false;
        int len1 = word1.length();
        int len2 = word2.length();
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        Set<Character> set = new HashSet<>();
        for(char c : word1.toCharArray()){
            a1[c - 'a']++;
            set.add(c);
        }
        int size = set.size();
        for(char c : word2.toCharArray()){
            a2[c - 'a']++;
            set.remove(c);
        }
        if(set.size() != 0) return false;
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
