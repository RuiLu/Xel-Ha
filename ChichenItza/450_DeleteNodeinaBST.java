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
       
       if (key < root.val) {
           root.left = deleteNode(root.left, key);
       } else if (key > root.val) {
           root.right = deleteNode(root.right, key);
       } else {
           /* case 1 -> both subtrees are null */
           if (root.left == null && root.right == null) return null;
           
           /* case 2 -> One of the subtree is null */
           if (root.left == null) return root.right;
           else if (root.right == null) return root.left;
           
           /* case 3 -> both subtree are not null */
           TreeNode minNode = findMinNode(root.right);
           root.val = minNode.val;
           root.right = deleteNode(root.right, minNode.val);
        }
       
        return root;   
    }
    
    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }
}
