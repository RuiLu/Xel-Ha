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
     *  Inorder dfs traversal
     *  Time complexity -> O(n)
     */
    private int totalSum = 0;
    
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }
    
    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            totalSum += sum;
            return;
        }
        
        dfs(node.left, sum);
        dfs(node.right, sum);
    }
}
