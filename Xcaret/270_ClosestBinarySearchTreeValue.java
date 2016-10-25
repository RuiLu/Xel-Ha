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
     *  Idea -> Binary Search
     *  Time complexity -> O(logn)
     *  Space complexity -> O(1)
     */
    public int closestValue(TreeNode root, double target) {
        double minDiff = Double.MAX_VALUE;
        int res = 0;
        
        while (root != null) {
            if ((double)root.val == target) return root.val;
            
            double diff = Math.abs((double)root.val - target);
            if (diff <= minDiff) {
                minDiff = diff;
                res = root.val;
            }
            
            if ((double)root.val < target) root = root.right;
            else root = root.left;
        }
        
        return res;
    }
}
