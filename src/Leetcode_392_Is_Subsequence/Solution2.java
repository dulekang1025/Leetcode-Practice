package Leetcode_392_Is_Subsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO: This solution can not pass all the cases
class Solution2 {
    public boolean isSubsequence(String s, String t) {
        // build a hash table to record characters and its index
        Map<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c)){
                map.get(c).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c, list);
            }
        }
        // search if s is a subsequence of t
        int prev = 0;
        for(int j = 0; j < s.length(); j++){
            char c = s.charAt(j);
            if(!map.containsKey(c)){
                return false;
            }else{
                // do binary search, use previous index as low
                List<Integer> list = map.get(c);
                int low = 0;
                int high = list.size() - 1;
                int mid = 0;
                while(low < high){
                    mid = low + (high - low) / 2;
                    if(list.get(mid) > prev) high = mid;
                    else low = mid + 1;
                }
                if(prev > list.get(low) || prev == list.size() - 1) return false;
                prev = list.get(low);
            }
        }
        return true;
    }

    public static void main(String[] args){
        String s = "abc";
        String t = "abcc";
        Solution2 s2 = new Solution2();
        System.out.println(s2.isSubsequence(s,t));
    }
}
