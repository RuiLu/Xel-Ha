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
     *  Idea -> Set up a global variable to keep the max path sum in time.
     *          If a path which goes to its parent has negative value, then we don't consider this path,
     *          set the sum to 0 directly.
     *  Time complexity -> O(n), since it accesses each node once
     *  Space complexity -> O(1)
     */
    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        getMaxPathSum(root);
        return maxSum;
    }
        
    private int getMaxPathSum(TreeNode node) {
        if (node == null) return 0;
        
        int left = Math.max(0, getMaxPathSum(node.left));
        int right = Math.max(0, getMaxPathSum(node.right));
        
        maxSum = Math.max(maxSum, left + node.val + right);
        
        return Math.max(left, right) + node.val;
    }     
}
