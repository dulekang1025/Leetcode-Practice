package Leetcode_987_Vertical_Order_Traversal_of_a_Binary_Tree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class Solution {
    TreeMap<Integer, List<Node>> map;
    List<List<Integer>> res;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map = new TreeMap<>();
        res = new ArrayList<>();
        dfs(root, 0, 0);
        helper();
        return res;
    }
    private void helper(){
        for(List<Node> list : map.values()){
            Collections.sort
                    (list, (a, b) -> a.y == b.y ? a.val - b.val : a.y - b.y);
            List<Integer> ans = new ArrayList<>();
            for(Node node : list){
                ans.add(node.val);
            }
            res.add(ans);
        }
    }
    private void dfs(TreeNode root, int x, int y){
        if(root == null) return;
        map.putIfAbsent(x, new ArrayList<>());
        Node node = new Node(x, y, root.val);
        map.get(x).add(node);
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }
    class Node{
        int x;
        int y;
        int val;
        public Node(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
