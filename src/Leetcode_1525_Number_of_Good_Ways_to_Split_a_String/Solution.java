package Leetcode_1525_Number_of_Good_Ways_to_Split_a_String;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numSplits(String s) {
        int[] arr = new int[26];
        int distinct = 0;
        for(char c : s.toCharArray()){
            if(arr[c - 'a'] == 0) distinct++;
            arr[c - 'a']++;
        }
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            set.add(c);
            arr[c - 'a']--;
            if(arr[c - 'a'] == 0) distinct--;
            if(set.size() == distinct) ans++;
        }
        return ans;
    }
}
