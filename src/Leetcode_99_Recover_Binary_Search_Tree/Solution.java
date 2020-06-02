package Leetcode_99_Recover_Binary_Search_Tree;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void recoverTree(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        inOrderTraversal(inOrder, root);
        int[] swaps = findSwapElement(inOrder);
        //System.out.println(swaps[0] + " " + swaps[1]);
        dfs(swaps, root);
    }
    private void inOrderTraversal(List<Integer> inOrder, TreeNode root){
        if(root == null) return;
        inOrderTraversal(inOrder, root.left);
        inOrder.add(root.val);
        inOrderTraversal(inOrder, root.right);
    }
    private int[] findSwapElement(List<Integer> inOrder){
        int x = -1;
        int y = -1;
        for(int i = 0; i < inOrder.size() - 1; i++){
            if(inOrder.get(i + 1) < inOrder.get(i)){
                y = inOrder.get(i + 1);
                if(x == -1) x = inOrder.get(i);
            }
        }
        return new int[]{x, y};
    }
    private void dfs(int[] swaps, TreeNode node){
        if(node == null) return;
        if(node.val == swaps[0]){
            node.val = swaps[1];
        }else if(node.val == swaps[1]){
            node.val = swaps[0];
        }
        dfs(swaps, node.right);
        dfs(swaps, node.left);
    }
}
