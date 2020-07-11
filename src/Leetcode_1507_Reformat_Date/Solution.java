package Leetcode_1507_Reformat_Date;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String reformatDate(String date) {
        String[] month = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, String> map = new HashMap<>();
        for(int i = 0; i < month.length; i++){
            if(i + 1 < 10){
                map.put(month[i], "0" + (i + 1));
            }else{
                map.put(month[i], (i + 1) + "");
            }
        }
        String[] arr = date.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[2]);
        sb.append('-');
        sb.append(map.get(arr[1]));
        sb.append('-');
        int st = arr[0].indexOf("st");
        int nd = arr[0].indexOf("nd");
        int rd = arr[0].indexOf("rd");
        int th = arr[0].indexOf("th");
        int index = Math.max(th, Math.max(st, Math.max(nd, rd)));
        String day = arr[0].substring(0, index);
        if(day.length() == 1){
            sb.append('0');
            sb.append(day);
        }else{
            sb.append(day);
        }
        return sb.toString();
    }
}
