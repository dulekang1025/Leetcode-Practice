package Leetcode_993_Cousins_in_Binary_Tree;

import TreeNode.TreeNode;

import java.util.*;

class Solution2 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<TreeNode> list = new ArrayList<>();
            int found = 0;
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.val == x || cur.val == y){
                    found++;
                    list.add(cur);
                    if(found == 2){
                        if(map.get(list.get(0)) != map.get(list.get(1))) return true;
                        else return false;
                    }
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                    map.put(cur.left, cur);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                    map.put(cur.right, cur);
                }
            }
        }
        return false;
    }
}
