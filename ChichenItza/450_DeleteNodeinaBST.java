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
     * Idea -> 1. Recursively find the node with the same value as key
     *         2. Once the node is found, have to handle the following 4 cases
     *            - node doesn't have left and right subtrees, return null
     *            - node only has left subtree, return the left subtree
     *            - node only has right subtree, return the right subtree
     *            - node has both left and right subtrees, find the min node from right substree,
     *              then assign that value to the current found node, then recursively delete the min node
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            /* 1. has no subtree */
            if (root.left == null && root.right == null) return null;
            
            /* 2. has only one non-null subtree */
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            
            /* 3. has both subtrees */
            TreeNode min = findMinNode(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right, min.val);
        }
        
        return root;
    }
    
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
