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
     *  Reference -> https://discuss.leetcode.com/topic/28913/very-easy-java-solution-post-order-recursion
     */
    int res = 0;
    
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        
        postOrderDFS(root);
         
        return res;
    }
    
    private boolean postOrderDFS(TreeNode node) {
        if (node == null) return true;
        
        boolean left = postOrderDFS(node.left);
        boolean right = postOrderDFS(node.right);
        
        if (left && right) {
            if (node.left != null && node.val != node.left.val) return false;
            if (node.right != null && node.val != node.right.val) return false;
            res++;
            return true;
        }
        
        return false;
    }
}
