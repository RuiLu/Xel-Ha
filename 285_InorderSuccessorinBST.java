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
     *  1. Recursive
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left; 
        }
    }
    
    /**
     *  2. Using While to reduce recursion
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        while (root != null && root.val <= p.val) {
            root = root.right;
        }
        if (root == null) return null;
        TreeNode left = inorderSuccessor(root.left, p);
        return (left != null && left.val > p.val) ? left : root;
    }
    
}
