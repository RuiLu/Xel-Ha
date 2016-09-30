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
     *  Get both heights of left and right subtrees, return the minimum one plus one
     *  Time complexity -> O(h), where h is the deepest height of tree
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return getMinDepth(root);
    }
    
    private int getMinDepth(TreeNode node) {
        if (node == null) return 0;
        
        int leftHeight = getMinDepth(node.left);
        int rightHeight = getMinDepth(node.right);
        
        return Math.min(leftHeight, rightHeight) + 1;
    }
}
