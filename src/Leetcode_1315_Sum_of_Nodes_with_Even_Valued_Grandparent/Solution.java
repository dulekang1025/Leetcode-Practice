package Leetcode_1315_Sum_of_Nodes_with_Even_Valued_Grandparent;

import TreeNode.TreeNode;

class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, false, false);
    }
    private int helper(TreeNode root, boolean isParentEven, boolean isGrandParentEven){
        if(root == null) return 0;
        boolean isSelfEven = root.val % 2 == 0;
        int left = helper(root.left, isSelfEven, isParentEven);
        int right = helper(root.right, isSelfEven, isParentEven);
        return left + right + (isGrandParentEven ? root.val : 0);
    }
}
