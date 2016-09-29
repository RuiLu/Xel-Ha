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
        return isValidBST(root.left, Long.MIN_VALUE, root.val) &&
              isValidBST(root.right, root.val, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode node, long min, long max) {
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
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode left = null;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            TreeNode node = stack.pop();
            if (left != null && left.val >= node.val) return false;
            left = node;
            curr = node.right;
        }
        
        return true;
    }
}
