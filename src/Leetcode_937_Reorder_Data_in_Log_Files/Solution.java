package Leetcode_937_Reorder_Data_in_Log_Files;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        // put string log and digit log into differnt list
        List<String> d_list = new ArrayList<>();
        List<String[]> s_list = new ArrayList<>();
        for(int i = 0; i < logs.length; i++){
            String s = logs[i];
            String[] arr = s.split(" ", 2);
            if(Character.isDigit(arr[1].charAt(0))){
                d_list.add(s);
            }else{
                s_list.add(arr);
            }
        }
        String[] ans = new String[logs.length];
        Collections.sort(s_list,
                (a, b) -> a[1].compareTo(b[1]) == 0 ? a[0].compareTo(b[0]) : a[1].compareTo(b[1]));
        for(int i = 0; i < s_list.size(); i++){
            ans[i] = s_list.get(i)[0] + " " + s_list.get(i)[1];
        }
        for(int i = s_list.size(); i < ans.length; i++){
            ans[i] = d_list.get(i - s_list.size());
        }
        return ans;
    }
}
