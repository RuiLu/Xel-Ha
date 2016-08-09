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
    // 1. Iteration - inorder
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                if (prev != null && prev.val >= node.val) return false;
                prev = node;
                curr = node.right;
            }
        }
        return true;
    }
    
    /*
     * 2. Recursion 
     * Trick -> use null to avoid int overflow
     */ 
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    
    private boolean helper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
        return (min == null || node.val > min) && 
              (max == null || node.val < max) && 
              helper(node.left, min, node.val) && 
              helper(node.right, node.val, max);
    }
}
