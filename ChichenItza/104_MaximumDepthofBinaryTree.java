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
     * Idea -> DFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int[] maxHeight = new int[1];
        dfs(root, maxHeight, 1);
        return maxHeight[0];
    }
    
    private void dfs(TreeNode node, int[] maxHeight, int height) {
        if (node == null) return;
        
        maxHeight[0] = Math.max(maxHeight[0], height);
        dfs(node.left, maxHeight, height+1);
        dfs(node.right, maxHeight, height+1);
    }
    
    /**
     * Idea -> BFS
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        
        int maxDepth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            maxDepth++;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        
        return maxDepth;
    }
}
