package Leetcode_113_Path_SumII;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curresult = new LinkedList<>();
        helper(root,sum,result,curresult);
        return result;

    }
    public void helper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> curres){
        if(root == null) return;
        curres.add(root.val);
        if(root.left == null && root.right == null && sum - root.val == 0){
            res.add(new LinkedList(curres));
            curres.remove(curres.size() - 1);
            return;
        }
        else {
            helper(root.left,sum - root.val,res,curres);
            helper(root.right,sum - root.val,res,curres);
        }
        curres.remove(curres.size() - 1);


    }
}