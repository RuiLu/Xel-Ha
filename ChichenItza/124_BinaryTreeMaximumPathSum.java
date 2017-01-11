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
    /**
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode node) {
        if (node == null) return 0;
        
        // get the longest path sum from left and right subtrees, 
        // if returned value is negative, we set it to 0
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        
        max = Math.max(max, left+right+node.val);
        
        return Math.max(left, right)+node.val;
    }
}
