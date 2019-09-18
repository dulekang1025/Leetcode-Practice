package Leetcode_653_Two_Sum_IV;

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> l = new ArrayList<>();
        pre(root,l);
        for(int i=0;i<l.size();i++){
            for(int j=i+1;j<l.size();j++){
                if((l.get(i) + l.get(j)) == k) return true;
            }
        }
        return false;
    }
    public void pre(TreeNode root, List<Integer> l){
        if(root == null) return;
        l.add(root.val);
        if(root.left != null){
            pre(root.left,l);
        }
        if(root.right != null){
            pre(root.right,l);
        }
    }
}
