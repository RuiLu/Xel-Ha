/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 1. in order, with queue and dfs (Time Limit Exceed)
// public class Solution {
//     public void flatten(TreeNode root) {
//         if (root == null) return;
//         Queue<TreeNode> queue = new LinkedList<>();
//         dfs(queue, root);
        
//         while (!queue.isEmpty()) {
//             root.left = null;
//             root.right = queue.poll();
//             root = root.right;
//         }
//     }
    
//     private void dfs(Queue<TreeNode> queue, TreeNode node) {
//         if (node == null) return;
//         queue.add(node);
//         dfs(queue, node.left);
//         dfs(queue, node.right);
//     }
// }


// 2. post order, from right to left
public class Solution {
    
    private TreeNode prev = null;
    
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    
}
