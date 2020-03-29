package Leetcode_652_Find_Duplicate_Subtrees;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private List<TreeNode> ans = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        helper(root);
        return ans;
    }
    private String helper(TreeNode root){
        if(root == null) return "#";
        String temp = Integer.toString(root.val) +
                helper(root.left) + helper(root.right);
        if(map.containsKey(temp)){
            int t = map.get(temp) + 1;
            map.put(temp, t);
        }else{
            map.put(temp, 1);
        }
        if(map.get(temp) == 2) this.ans.add(root);
        return temp;
    }
}
