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
     *  DFS + Divide and Conquer
     *  Time complexity -> O(n), since we need to create node for every element in nums
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int lo, int hi) {
        if (lo > hi) return null;
        
        int mid = (lo + hi) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBST(nums, lo, mid - 1);
        root.right = buildBST(nums, mid + 1, hi);
        
        return root;
    }
}
