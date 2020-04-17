package Leetcode_1054_Distant_Barcodes;

import java.util.*;

class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Arrays.sort(barcodes);
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int num = 0;
        for(int i : barcodes){
            map.put(i, map.getOrDefault(i, 0) + 1);
            if(map.get(i) > max){
                max = map.get(i);
                num = i;
            }
        }
        List<List<Integer>> lists = new ArrayList<>();
        int temp = max;
        while(temp > 0){
            List<Integer> list = new ArrayList<>();
            list.add(num);
            lists.add(list);
            temp--;
        }
        int listIndex = 0;
        for(int i = 0; i < barcodes.length; i++){
            if(barcodes[i] == num) continue;
            lists.get(listIndex++).add(barcodes[i]);
            if(listIndex == max) listIndex = 0;
        }
        int[] ans = new int[barcodes.length];
        int i = 0;
        for(List<Integer> l : lists){
            for(int n : l){
                ans[i++] = n;
            }
        }
        return ans;
    }
}
