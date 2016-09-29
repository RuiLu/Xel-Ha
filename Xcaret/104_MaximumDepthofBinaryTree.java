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
     *  Simply do dfs traversal to the whole tree and find the maximum depth
     *  Time complexity -> O(n)
     *  Space complexity -> O(h)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int[] deepest = new int[1];
        dfs(root, deepest, 0);
        return deepest[0];
    }
    
    private void dfs(TreeNode node, int[] deepest, int level) {
        if (node == null) {
            deepest[0] = Math.max(deepest[0], level);
            return;
        }
        dfs(node.left, deepest, level + 1);
        dfs(node.right, deepest, level + 1);
    }
}
