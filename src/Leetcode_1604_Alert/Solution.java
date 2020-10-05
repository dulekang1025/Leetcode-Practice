package Leetcode_1604_Alert;

import java.util.*;

class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < keyName.length; i++){
            map.putIfAbsent(keyName[i], new ArrayList<>());
            map.get(keyName[i]).add(keyTime[i]);
        }
        List<String> ans = new ArrayList<>();
        for(String name : map.keySet()){
            if(map.get(name).size() < 3) continue;
            System.out.print(name + " ");
            if(helper(map.get(name))){
                ans.add(name);
            }
        }
        Collections.sort(ans, (a, b) -> a.compareTo(b));
        return ans;
    }
    private boolean helper(List<String> time){
        Collections.sort(time, (a, b) -> a.compareTo(b));
        System.out.println(time);
        int count = 1;
        String prev = time.get(0);
        int i = 1;
        int pr = 0;
        while(i < time.size()){
            String[] p = prev.split(":");
            int prevHour = Integer.valueOf(p[0]);
            int prevMin = Integer.valueOf(p[1]);
            String[] c = time.get(i).split(":");
            int curHour = Integer.valueOf(c[0]);
            int curMin = Integer.valueOf(c[1]);
            // ["23:58","23:59","00:01"]
            // [12:00, 12:01, 18:00]
            if(prevHour == curHour){
                count++;
                i++;
            }else if(curHour - prevHour <= 1){
                if(prevMin >= curMin){
                    count++;
                    i++;
                }else{
                    count = 1;
                    pr++;
                    prev = time.get(pr);
                    i = pr + 1;
                }
            }else{
                count = 1;
                pr++;
                prev = time.get(pr);
                i = pr + 1;
            }
            if(count >= 3) return true;
        }
        return false;
    }
}
