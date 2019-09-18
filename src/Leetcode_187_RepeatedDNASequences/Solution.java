package Leetcode_187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> l = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        if(s.length() < 10) return new ArrayList<String>(l);
        for(int i = 0; i <= s.length() - 10; i++){
            String temp = s.substring(i,i+10);
            if(set.contains(temp)){
                l.add(temp);
            }else{
                set.add(temp);
            }
        }
        return new ArrayList<String>(l);
    }
}
