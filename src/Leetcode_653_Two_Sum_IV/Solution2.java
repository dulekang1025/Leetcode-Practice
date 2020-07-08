package Leetcode_653_Two_Sum_IV;

import TreeNode.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new LinkedList<>();
        inOrder(root, list);
        int low = 0, high = list.size() - 1;
        while(low < high){
            int sum = list.get(low) + list.get(high);
            if(sum > k){
                high--;
            }else if(sum < k){
                low++;
            }else{
                return true;
            }
        }
        return false;
    }
    private void inOrder(TreeNode root, List<Integer> list){
        if(root == null) return;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
}
