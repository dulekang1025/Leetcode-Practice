package Leetcode_654_Maximum_Binary_Tree;

import TreeNode.TreeNode;

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        return generateBT(nums, 0, nums.length - 1);
    }
    private TreeNode generateBT(int[] nums, int s, int e){
        if(s > e) return null;
        int max = findMax(nums, s, e);
        TreeNode root = new TreeNode(nums[max]);
        root.left = generateBT(nums, s, max - 1);
        root.right = generateBT(nums, max + 1, e);
        return root;
    }
    private int findMax(int[] nums, int s, int e){
        int max_pos = -1;
        int temp_max = Integer.MIN_VALUE;
        for(int i = s; i <= e; i++){
            if(nums[i] > temp_max){
                temp_max = nums[i];
                max_pos = i;
            }
        }
        return max_pos;
    }
}
