package Leetcode_1612_Check_If_Two_Expression_Trees_are_Equivalent;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();
    public boolean checkEquivalence(Node root1, Node root2) {
        helper(root1, map1);
        helper(root2, map2);
        for(Character c : map1.keySet()){
            if(!map2.containsKey(c) || !map1.get(c).equals(map2.get(c))){
                return false;
            }
        }
        return map1.size() == map2.size();
    }
    public void helper(Node root, Map<Character, Integer> map){
        if(root.left == null && root.right == null){
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            return;
        }
        helper(root.left, map);
        helper(root.right, map);
    }
}

  class Node {
      char val;
      Node left;
      Node right;
      Node() {this.val = ' ';}
      Node(char val) { this.val = val; }
      Node(char val, Node left, Node right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

