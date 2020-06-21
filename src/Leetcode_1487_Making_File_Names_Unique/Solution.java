package Leetcode_1487_Making_File_Names_Unique;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        for(String s : names){
            if(!map.containsKey(s)){
                map.put(s, 1);
                res[i++] = s;
            }else{
                int count = map.get(s);
                while(map.containsKey(s + "(" + count + ")")){
                    count++;
                }
                map.put(s + "(" + count + ")", 1);
                map.put(s, map.get(s) + 1);   // reduce loop times
                res[i++] = s + "(" + count + ")";
            }
        }
        return res;
    }
}
