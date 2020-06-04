package Leetcode_1123_Lowest_Common_Ancestor_of_Deepest_Leaves;

import TreeNode.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
    Map<TreeNode, TreeNode> map = new HashMap();
    Queue<TreeNode> queue = new LinkedList<>();
    int maxDepth = Integer.MIN_VALUE;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, root, 0);
        while(queue.size() > 1){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                TreeNode parent = map.get(cur);
                if(!queue.contains(parent)){
                    queue.offer(parent);
                }
            }
        }
        return queue.poll();
    }
    private void dfs(TreeNode node, TreeNode parent, int depth){
        if(node == null) return;
        map.put(node, parent);
        if(depth == maxDepth){
            queue.offer(node);
        }else if(depth > maxDepth){
            queue.clear();
            queue.offer(node);
            maxDepth = depth;
        }
        dfs(node.left, node, depth + 1);
        dfs(node.right, node, depth + 1);
    }
}
