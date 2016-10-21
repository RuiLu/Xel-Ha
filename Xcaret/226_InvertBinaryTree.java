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
     *  Idea -> DFS
     *  Time complexity -> O(n)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = invertTree(right);
        root.right = invertTree(left);
        
        return root;
    }
    
    /**
     *  Idea -> BFS
     *  Time complexity -> O(n)
     */ 
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return root;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
            
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
        }
        
        return root;
    }
}
