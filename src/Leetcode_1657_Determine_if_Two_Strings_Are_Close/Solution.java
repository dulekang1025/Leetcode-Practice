package Leetcode_1657_Determine_if_Two_Strings_Are_Close;

import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.equals(word2)) return true;
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 != len2) return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        Set<Character> set = new HashSet<>();
        for(char c : word1.toCharArray()){
            a1[c - 'a']++;
            set.add(c);
        }
        for(char c : word2.toCharArray()){
            a2[c - 'a']++;
            if(set.contains(c))
                set.remove(c);
        }
        if(set.size() != 0) return false;
        System.out.println(1);
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            l1.add(a1[i]);
        }
        for(int i = 0; i < 26; i++){
            l2.add(a2[i]);
        }
        Collections.sort(l1);
        Collections.sort(l2);
        for(int i = 0; i < l1.size(); i++){
            if(!l1.get(i).equals(l2.get(i))) return false;
        }
        return true;
    }
}
