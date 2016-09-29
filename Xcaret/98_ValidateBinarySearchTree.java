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
     *  DFS, recursion.
     *  Inorder to avoid Integer overflow, use Long to do calculation
     *  Time complexity -> O(2^h), where h is the height of tree
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        
        if ((long)node.val <= min || (long)node.val >= max) return false;
        
        return isValidBST(node.left, min, (long)node.val) && 
               isValidBST(node.right, (long)node.val, max);
    }
    
    /**
     *  Iteration, inorder
     */
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            TreeNode node = stack.pop();
            if (prev != null && prev.val >= node.val) return false;
            prev = node;
            root = node.right;
        }
        
        return true;
    }
}
