package Leetcode_352_Data_Stream_as_Disjoint_Intervals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

class SummaryRanges {

    TreeSet<Integer> set = new TreeSet<>();

    /** Initialize your data structure here. */
    public SummaryRanges() {

    }

    public void addNum(int val) {
        set.add(val);
    }

    public int[][] getIntervals() {
        List<int[]> list = new ArrayList<>();
        Iterator<Integer> it = set.iterator();
        int[] interval = new int[2];
        while(it.hasNext()){
            int num = it.next();
            if(set.contains(num - 1) && set.contains(num + 1)){
                continue;
            }else if(!set.contains(num - 1) && !set.contains(num + 1)){
                interval[0] = num;
                interval[1] = num;
                list.add(interval);
                interval = new int[2];
            }else if(!set.contains(num - 1) && set.contains(num + 1)){
                interval[0] = num;
            }else if(set.contains(num - 1) && !set.contains(num + 1)){
                interval[1] = num;
                list.add(interval);
                interval = new int[2];
            }
        }
        int[][] ans = new int[list.size()][2];
        Iterator<int[]> iter = list.iterator();
        for(int i = 0; i < ans.length; i++){
            ans[i] = iter.next();
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
