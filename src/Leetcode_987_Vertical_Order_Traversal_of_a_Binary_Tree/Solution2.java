package Leetcode_987_Vertical_Order_Traversal_of_a_Binary_Tree;

import TreeNode.TreeNode;

import java.util.*;

public class Solution2 {
    Map<Integer, List<int[]>> map = new TreeMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        sort();
        return ans;
    }
    private void dfs(TreeNode root, int l, int r){
        if(root == null) return;
        map.putIfAbsent(l, new ArrayList<>());
        map.get(l).add(new int[]{r, root.val});
        dfs(root.left, l - 1, r - 1);
        dfs(root.right, l + 1, r - 1);
    }
    private void sort(){
        for(int key : map.keySet()){
            Collections.sort(map.get(key), (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            List<Integer> list = new ArrayList<>();
            for(int[] n : map.get(key)){
                list.add(n[1]);
            }
            ans.add(list);
        }
    }
}
