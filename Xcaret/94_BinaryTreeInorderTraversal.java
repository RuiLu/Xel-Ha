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
     *  1. DFS, recursion
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }
    
    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;    
        }
        
        dfs(node.left, res);
        res.add(node.val);
        dfs(node.right, res);
    }
    
    /**
     *  2. Iteration, with a stack
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        
        return res;
    }
}
