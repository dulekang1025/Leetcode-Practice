package Leetcode_1286_Iterator_for_Combination;

import java.util.ArrayList;
import java.util.List;

class CombinationIterator {

    List<List<Character>> ans = new ArrayList<>();
    int index = 0;

    public CombinationIterator(String characters, int combinationLength) {
        dfs(0, characters, combinationLength, new ArrayList<>());
    }

    public String next() {
        StringBuilder sb = new StringBuilder();
        for(char c : ans.get(index++)){
            sb.append(c);
        }
        return sb.toString();
    }

    public boolean hasNext() {
        if(index < ans.size()) return true;
        else return false;
    }

    private void dfs(int start, String s, int len, List<Character> list){
        if(list.size() == len){
            ans.add(new ArrayList<>(list));
        }
        for(int i = start; i < s.length(); i++){
            list.add(s.charAt(i));
            dfs(i + 1, s, len, list);
            list.remove(list.size() - 1);
        }
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
