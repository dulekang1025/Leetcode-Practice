package Leetcode_1048_Longest_String_Chain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        List<String>[] wordList = new List[17];
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            int len = word.length();
            if(wordList[len] == null) wordList[len] = new ArrayList<>();
            wordList[len].add(word);
            map.put(word, 1);
        }
        int max = 1;
        for(int i = 1; i < 17; i++){
            if(wordList[i] == null) continue;
            for(String word1 : wordList[i]){
                int preLen = i - 1;
                if(wordList[preLen] == null) continue;
                for(String word2 : wordList[preLen]){
                    if(isPre(word2, word1)){
                        map.put(word1, Math.max(map.get(word2) + 1, map.get(word1)));
                        max = Math.max(max, map.get(word1));
                    }
                }
            }

        }
        return max;
    }

    private boolean isPre(String w1, String w2){
        int p1 = 0, p2 = 0;
        boolean found = false;
        while(p1 < w1.length() && p2 < w2.length()){
            if(w1.charAt(p1) == w2.charAt(p2)){
                p1++;
                p2++;
            }else if(found){
                return false;
            }else{
                found = true;
                p2++;
            }
        }
        return true;
    }
}
