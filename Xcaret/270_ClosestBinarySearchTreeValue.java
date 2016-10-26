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
            if (Math.abs(target - (double)root.val) <= minDiff) {
                minDiff = Math.abs(target - (double)root.val);
                if (minDiff == 0.0) return root.val;
                res = root.val;
            }
            
            if ((double)root.val > target) root = root.left;
            else root = root.right;   
        }
        
        return res;
    }
}
