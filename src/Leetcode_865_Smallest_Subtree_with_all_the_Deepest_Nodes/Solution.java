package Leetcode_865_Smallest_Subtree_with_all_the_Deepest_Nodes;

import TreeNode.TreeNode;

import java.util.*;

class Solution {
    int maxDepth = 0;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Map<TreeNode, TreeNode> childToParent = new HashMap<>();
        Set<TreeNode> deepest = new HashSet<>();
        Queue<TreeNode> deepestQueue = new LinkedList<>();
        dfs(root, root, childToParent, deepestQueue, 0);
        // for(TreeNode t : deepestQueue){
        //     System.out.println(t.val);
        // }
        while(deepestQueue.size() != 1){
            int size = deepestQueue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = deepestQueue.poll();
                TreeNode parent = childToParent.get(cur);
                if(!deepestQueue.contains(parent)){
                    deepestQueue.add(parent);
                }
            }
        }
        return deepestQueue.poll();
    }
    private void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> childToParent, Queue<TreeNode> deepestQueue, int depth){
        if(node == null) return;
        childToParent.put(node, parent);
        if(depth == maxDepth){
            deepestQueue.add(node);
        }else if(depth > maxDepth){
            deepestQueue.clear();
            maxDepth = depth;
            deepestQueue.add(node);
        }
        dfs(node.left, node, childToParent, deepestQueue, depth + 1);
        dfs(node.right, node, childToParent, deepestQueue, depth + 1);
    }
}
