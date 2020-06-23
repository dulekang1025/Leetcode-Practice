package Leetcode_352_Data_Stream_as_Disjoint_Intervals;

import java.util.Iterator;
import java.util.TreeSet;

class SummaryRanges2 {

    TreeSet<int[]> set;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        set = new TreeSet<>((a, b) -> a[0] - b[0]);
    }

    public void addNum(int val) {
        int[] t = new int[]{val, val};
        int[] floor = set.floor(t);
        if(floor != null){
            if(val <= floor[1]){
                return;
            }else if(val == floor[1] + 1){
                t[0] = floor[0];
                set.remove(floor);
            }
        }
        int[] higher = set.higher(t);
        if(higher != null){
            if(t[1] + 1 == higher[0]){
                t[1] = higher[1];
                set.remove(higher);
            }
        }
        set.add(t);
    }

    public int[][] getIntervals() {
        int[][] ans = new int[set.size()][2];
        Iterator<int[]> it = set.iterator();
        for(int i = 0; i < ans.length; i++){
            ans[i] = it.next();
        }
        return ans;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
