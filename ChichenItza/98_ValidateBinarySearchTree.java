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
     * Idea -> Need to pass both lower and upper bounds to child nodes.
     *         Use Long as the type of bounds in order to avoid Integer Overflow.
     * Time complexity -> O(n)
     * Space complexity -> O(1)
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, Long.MIN_VALUE, root.val) && 
               helper(root.right, root.val, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) return true;
        
        if (node.val >= upper || node.val <= lower) return false;
        
        return helper(node.left, lower, node.val) && 
               helper(node.right, node.val, upper);
    }
}
