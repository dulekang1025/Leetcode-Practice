package Leetcode_993_Cousins_in_Binary_Tree;

import TreeNode.TreeNode;

import java.util.HashMap;

class Solution {
    HashMap<Integer, TreeNode> map_p = new HashMap<>();
    HashMap<Integer, Integer> map_d = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0);
        return find(x, y);
    }
    public void dfs(TreeNode root, int depth){
        if(root == null) return;
        if(root.left != null) {
            map_p.put(root.left.val, root);
            map_d.put(root.left.val, depth);
            dfs(root.left, depth + 1);

        }
        if(root.right != null) {
            map_p.put(root.right.val, root);
            map_d.put(root.right.val, depth);
            dfs(root.right, depth + 1);
        }
    }
    public boolean find(int x, int y){
        if(map_p.get(x) == map_p.get(y)) return false;
        if(map_d.get(x) == map_d.get(y)) return true;
        return false;
    }
}
