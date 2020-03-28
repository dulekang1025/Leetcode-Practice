package Leetcode_863_All_Nodes_Distance_K_in_Binary_Tree;

import TreeNode.TreeNode;

import java.util.*;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        List<TreeNode> visited = new ArrayList<>();
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        generateGraph(root, null, graph);
        q.offer(target);
        res.add(target.val);
        if(graph.size() == 0 && root == target && K == 0) return res;
        else if(graph.size() == 0) return new ArrayList<>();
        //bfs
        while(!q.isEmpty() && K > 0){
            int n = q.size();
            res.clear();
            for(int i = 0; i < n; i++){
                TreeNode cur = q.poll();
                visited.add(cur);
                for(TreeNode node: graph.get(cur)){
                    if(!visited.contains(node)){
                        q.offer(node);
                        res.add(node.val);
                    }
                }
            }
            K--;
        }
        return res;
    }
    private void generateGraph(TreeNode node, TreeNode pre, Map<TreeNode, List<TreeNode>> graph){
        if(node == null) return;
        if(pre != null){
            if(graph.containsKey(pre)){
                graph.get(pre).add(node);
            }
            else{
                graph.put(pre, new ArrayList<TreeNode>());
                graph.get(pre).add(node);
            }
            if(graph.containsKey(node)){
                graph.get(node).add(pre);
            }else{
                graph.put(node, new ArrayList<TreeNode>());
                graph.get(node).add(pre);
            }
        }
        generateGraph(node.left, node, graph);
        generateGraph(node.right, node, graph);
    }
}
