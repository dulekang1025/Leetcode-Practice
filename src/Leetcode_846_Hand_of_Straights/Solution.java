package Leetcode_846_Hand_of_Straights;

import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length % W != 0) return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int h : hand){
            if(!map.containsKey(h)){
                map.put(h, 1);
            }else{
                map.replace(h, map.get(h) + 1);
            }
        }
        while(map.size() > 0){
            int first = map.firstKey();
            for(int i = first; i < first + W; i++){
                if(!map.containsKey(i)) return false;
                int count = map.get(i);
                if(count == 1) map.remove(i);
                else map.replace(i, count - 1);
            }
        }
        return true;
    }
}
