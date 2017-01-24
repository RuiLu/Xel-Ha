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
     * Idea -> Recursion, with help from ArrayList
     * Time complexity -> O(n)
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(res, root, 1);
        return res;
    }
    
    private void dfs(List<Integer> res, TreeNode node, int height) {
        if (node == null) return;
        if (res.size() < height) res.add(node.val);
        dfs(res, node.right, height+1);
        dfs(res, node.left, height+1);
    }
    
    /**
     * Idea -> BFS
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) res.add(node.val);
                if (node.right != null) queue.offer(node.right);
                if (node.left != null) queue.offer(node.left);
            }
        }
        
        return res;
     }
}
