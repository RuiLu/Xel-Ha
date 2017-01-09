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
     *  Idea -> Simple DFS, passing parent's value to children and compare their values.
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */ 
    private int maxLength = 0;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) return maxLength;
        helper(root, root.val-1, 0);
        return maxLength;
    }
    
    private void helper(TreeNode node, int target, int length) {
        if (node == null) return;
        if (node.val == target) length++;
        else length = 1;
        maxLength = Math.max(maxLength, length);
        helper(node.left, node.val+1, length);
        helper(node.right, node.val+1, length);
    }
}
