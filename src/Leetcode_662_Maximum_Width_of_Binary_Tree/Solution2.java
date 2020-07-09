package Leetcode_662_Maximum_Width_of_Binary_Tree;

import TreeNode.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if(root == null) return max;
        LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 1));
        while(!queue.isEmpty()){
            int size = queue.size();
            int curWidth = queue.get(size - 1).getValue() - queue.get(0).getValue() + 1;
            max = Math.max(max, curWidth);
            for(int i = 0; i < size; i++){
                Pair<TreeNode, Integer> cur = queue.poll();
                TreeNode node = cur.getKey();
                int index = cur.getValue();
                if(node.left != null) queue.offer(new Pair<>(node.left, index * 2));
                if(node.right != null) queue.offer(new Pair<>(node.right, index * 2 + 1));
            }
        }
        return max;
    }
}
