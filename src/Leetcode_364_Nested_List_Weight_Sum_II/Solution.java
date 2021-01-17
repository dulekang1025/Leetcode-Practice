package Leetcode_364_Nested_List_Weight_Sum_II;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> arr = new ArrayList<>();
    public int depthSumInverse(List<NestedInteger> nestedList) {
        dfs(nestedList, 1);
        int depth = arr.size();
        // System.out.println(arr);
        // System.out.println(depth);
        int sum = 0;
        for(int num : arr){
            sum += num * depth;
            depth--;
        }
        return sum;
    }
    private void dfs(List<NestedInteger> list, int level){
        if(arr.size() < level){
            arr.add(0);
        }
        int sum = 0;
        for(NestedInteger nest : list){
            if(nest.isInteger()){
                sum += nest.getInteger();
            }else{
                dfs(nest.getList(), level + 1);
            }
        }
        arr.set(level - 1, arr.get(level - 1) + sum);
    }
}

class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger(){};

    // Constructor initializes a single integer.
    public NestedInteger(int value){};

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){return true;};

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){return null;};

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){};

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){};

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){return null;};
}
