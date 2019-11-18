package Leetcode_108_Convert_Sorted_Array_to_Binary_Search_Tree;

import TreeNode.TreeNode;


class Solution {

    //todo why this not work?

//     public TreeNode sortedArrayToBST(int[] nums) {
//         if(nums.length == 0) return null;
//         if(nums.length == 1) {
//             TreeNode root = new TreeNode(nums[0]);
//             return root;
//         }
//         int v = nums.length/2;
//         int k = nums[v];
//         int[] new_nums = new int[nums.length - 1];
//         for(int i=0;i<v;i++){
//             new_nums[i] = nums[i];
//         }
//         for(int j=v+1;j<nums.length;j++){
//             new_nums[j-1] = nums[j];
//         }

//         TreeNode root = new TreeNode(k);

//         return helper(root, new_nums);
//     }
//     public TreeNode helper(TreeNode root, int[] new_nums){
//         for(int i=0;i<new_nums.length;i++){
//             buildBST(root,new_nums[i]);
//         }
//         return root;
//     }

//     public void buildBST(TreeNode root, int n){
//         if(root.val > n){
//             if(root.left == null){
//                 root.left = new TreeNode(n);
//             }
//             else{
//                 buildBST(root.left,n);
//             }
//         }
//         if(root.val < n){
//             if(root.right == null){
//                 root.right = new TreeNode(n);
//             }
//             else{
//                 buildBST(root.right,n);
//             }
//         }
//     }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int low, int high){
        if(low > high) return null;
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,low,mid - 1);
        node.right = helper(nums,mid + 1,high);

        return node;
    }
}
