package Leetcode_107_BT_Lever_order;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        return helper(root, res);
    }
    public List<List<Integer>> helper(TreeNode root, List<List<Integer>> res){
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            List<Integer> l = new LinkedList<>();
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.pop();
                l.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(0,l);
        }
        return res;
    }
}
