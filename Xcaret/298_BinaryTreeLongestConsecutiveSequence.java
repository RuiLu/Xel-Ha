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
     *  Idea -> DFS while keeping track of the count of consecutive sequence
     *          Use a array to record the longest length
     *  Time complexity -> O(n)
     *  Space complexity -> O(1)
     */
    private static void dfsHelper(TreeNode node, int count, int[] res) {
        if (node == null) return;
        
        res[0] = Math.max(res[0], count);
        
        if (node.left != null) {
            if (node.val + 1 == node.left.val) dfsHelper(node.left, count + 1, res);
            else dfsHelper(node.left, 1, res);
        }
        if (node.right != null) {
            if (node.val + 1 == node.right.val) dfsHelper(node.right, count + 1, res);
            else dfsHelper(node.right, 1, res);
        }
    }
    
    public static int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int[] res = new int[1];
        dfsHelper(root, 1, res);
        return res[0];
    }
}
