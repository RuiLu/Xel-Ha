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
    private int maxPathSum;
    
    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        if (root == null) return 0;
        getMaxPathSum(root);
        return maxPathSum;
    }
    
    private int getMaxPathSum(TreeNode node) {
        if (node == null) return 0;
        
        int leftMax = Math.max(0, getMaxPathSum(node.left));
        int rightMax = Math.max(0, getMaxPathSum(node.right));
        
        maxPathSum = Math.max(maxPathSum, leftMax + rightMax + node.val);
        
        return Math.max(leftMax, rightMax) + node.val;
    }
}
