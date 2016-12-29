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
    
    // 1. Iteration -> slow
    public void recoverTree(TreeNode root) {
        TreeNode firstWrongNode = null;
        TreeNode secondWrongNode = null;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode prev = null;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                if (prev != null && prev.val >= node.val) {
                    if (firstWrongNode == null) {
                        firstWrongNode = prev;
                        
                    } 
                    if (firstWrongNode != null) {
                        secondWrongNode = node;
                    }
                }
                prev = node;
                curr = node.right;
            }
        }
        
        int tmp = firstWrongNode.val;
        firstWrongNode.val = secondWrongNode.val;
        secondWrongNode.val = tmp;
    }
    
    // 2. Recursion
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        dfs(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    // inorder traversal -> fast
    private void dfs(TreeNode node) {
        if (node == null) return;
        
        dfs(node.left);
        
        if (prev != null && first == null && node.val <= prev.val) {
            first = prev;
        }
        
        if (prev != null && first != null && node.val <= prev.val) {
            second = node;
        }
        
        prev = node;
        
        dfs(node.right);
    }
}
