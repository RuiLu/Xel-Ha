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
     *  Iteration
     *  Idea -> parent's right subtree becomes left child's left substree
     *          parent becomes left child's right substree.
     *  Time complexity -> O(h), where h is the height of tree
     *  Space complexity -> O(1)
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        
        TreeNode prev = null;
        TreeNode left = null;
        
        while (root != null) {
            TreeNode temp = root;
            root = root.left;
            
            temp.left = left;
            left = temp.right;
            temp.right = prev;
            prev = temp;
        }
        
        return prev;
    }
}
