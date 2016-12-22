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
     *  Idea -> The given tree is a random tree, we need to find the largest BST inside it.
     *          So, we need to create a class maintaining substree size, and its upper and lower bounds.
     *  
     *  Time complexity -> O(n)
     */
    class Result { 
        int size;
        int lower;
        int upper;
        
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    private int max = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }    
        dfs(root);
        return max;
    }
    
    private Result dfs(TreeNode node) {
        if (node == null) { return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
        Result left = dfs(node.left);
        Result right = dfs(node.right);
        
        
        if (left.size == -1 || right.size == -1 || node.val <= left.upper || node.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, left.lower == Integer.MAX_VALUE ? node.val : left.lower, 
                                right.upper == Integer.MIN_VALUE ? node.val : right.upper);
    }
}
