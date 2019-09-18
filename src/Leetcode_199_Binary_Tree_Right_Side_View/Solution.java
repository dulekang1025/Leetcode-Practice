package Leetcode_199_Binary_Tree_Right_Side_View;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 只输出了树的最右侧，wrong ans

//class Solution {
//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if(root == null) return res;
//
//        dfs(res,root);
//        return res;
//    }
//    public void dfs(List<Integer> res, TreeNode node){
//        if(node == null) return;
//        res.add(node.val);
//        dfs(res, node.right);
//
//    }
//}

// First, lever order traversal, store each level from left to right, then output the last element of the list.

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        // 1. level order traversal
        List<Integer> r = new ArrayList<>();
        LinkedList<LinkedList<Integer>> levelOrder = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null) return r;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> res = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode cur = queue.pop();
                res.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            levelOrder.add(res);
        }
        //2. store the last element of each list
        LinkedList<Integer> ans = new LinkedList<>();
        for(LinkedList<Integer> l : levelOrder){
            int s = l.get(l.size() - 1);
            ans.add(s);
        }
        return ans;
    }
}
