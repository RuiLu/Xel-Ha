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
     *  1. Recursion -> DFS
     */ 
    private int res = Integer.MIN_VALUE; 
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 1);
        return res;
    }
    
    private void dfs(TreeNode node, int height) {
        if (node.left != null) {
            if (node.left.val - node.val == 1) {
                dfs(node.left, height + 1);
            } else {
                res = Math.max(height, res);
                dfs(node.left, 1);
            }
        }
        if (node.right != null) {
            if (node.right.val - node.val == 1) {
                dfs(node.right, height + 1);
            } else {
                res = Math.max(height, res);
                dfs(node.right, 1);
            }
        }
        if (node.left == null && node.right == null) {
            res = Math.max(height, res);
        }
    }
    
    /**
     *  Same thought, but much more concise
     */ 
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfs(root, res, 0, root.val);
        return res[0];
    }
    
    private void dfs(TreeNode node, int[] res, int curr, int target) {
        if (node == null) return;
        if (node.val == target) curr++;
        else curr = 1;
        res[0] = Math.max(res[0], curr);
        dfs(node.left, res, curr, node.val + 1);
        dfs(node.right, res, curr, node.val + 1);
    }
    
}
