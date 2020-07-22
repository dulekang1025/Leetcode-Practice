package Leetcode_341_Flatten_Nested_List_Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Queue<Integer> res = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger n :nestedList){
            dfs(n);
        }
    }

    @Override
    public Integer next() {
        return res.poll();
    }

    @Override
    public boolean hasNext() {
        if(res.isEmpty()) return false;
        return true;
    }

    private void dfs(NestedInteger n){
        if(n.isInteger()){
            res.add(n.getInteger());
        }else{
            for(NestedInteger i : n.getList())
                dfs(i);
        }
    }
}
 class NestedInteger{
    public boolean isInteger(){ return true;}
    public Integer getInteger(){return null;}
    public List<NestedInteger> getList(){return null;}

 }

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
