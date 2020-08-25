package Leetcode_742_Closest_Leaf_in_a_Binary_Tree;

import TreeNode.TreeNode;

import java.util.*;

class Solution {
    Map<TreeNode, TreeNode> g = new HashMap<>();
    TreeNode start = null;
    public int findClosestLeaf(TreeNode root, int k) {
        if(root == null) return 0;
        buildGraph(root, null, k);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int d = 0;
        queue.add(start);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.left == null && cur.right == null) return cur.val;
            if(cur.left != null && !set.contains(cur.left.val)){
                queue.offer(cur.left);
                set.add(cur.left.val);
            }
            if(cur.right != null && !set.contains(cur.right.val)){
                queue.offer(cur.right);
                set.add(cur.right.val);
            }
            if(g.get(cur) != null && !set.contains(g.get(cur).val)){
                queue.offer(g.get(cur));
                set.add(g.get(cur).val);
            }
            d++;
        }
        return -1;
    }
    private void buildGraph(TreeNode root, TreeNode parent, int k){
        if(root == null) return;
        if(root.val == k) start = root;
        g.put(root, parent);
        buildGraph(root.left, root, k);
        buildGraph(root.right, root, k);
    }
}
