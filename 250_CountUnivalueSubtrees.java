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
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        postOrderDFS(root, res);
        return res[0];
    }
    
    private boolean postOrderDFS(TreeNode node, int[] res) {
        if (node == null) return true;
        
        boolean left = postOrderDFS(node.left, res);
        boolean right = postOrderDFS(node.right, res);
        
        if (left && right) {
            if (node.left != null && node.left.val != node.val) return false;
            if (node.right != null && node.right.val != node.val) return false;
            res[0]++;
            return true;
        }
        
        return false;
    }
}
